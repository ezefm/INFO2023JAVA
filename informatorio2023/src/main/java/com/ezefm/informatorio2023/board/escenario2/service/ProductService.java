package com.ezefm.informatorio2023.board.escenario2.service;

import com.ezefm.informatorio2023.board.escenario2.entity.Category;
import com.ezefm.informatorio2023.board.escenario2.entity.CrossedOutPrice;
import com.ezefm.informatorio2023.board.escenario2.entity.Price;
import com.ezefm.informatorio2023.board.escenario2.entity.Product;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    Scanner sc = new Scanner(System.in);
    public void showFiveProducts(List<Category> categories, List<Product> allProducts, int num){
        List<Product> firstFive;
        for (Category category : categories){
            List<Product> products = category.getProductList();
            allProducts.addAll(products);
        }
        if(num == 1){
            allProducts.sort((p1, p2) -> Double.compare(p2.getActualPrice().getValue(), p1.getActualPrice().getValue()));
        }else if(num == 2){
            allProducts.sort(Comparator.comparingDouble(product -> product.getActualPrice().getValue()));
        }
        firstFive = allProducts.subList(0, 5);
        for (Product product : firstFive){
            System.out.println(product.getName() + " : " + product.getActualPrice().getValue());
        }
        allProducts.clear();
    }
    private void getProducts(List<Product> allProducts) {
        for(Product product : allProducts) {
            double cop = (product.getCrossedOutPrice().getValue() != null ? product.getCrossedOutPrice().getValue() : 0.0);
            System.out.println("Name: " + product.getName() +
                    " Description: " + product.getDescription() +
                    " Online price: " + product.getActualPrice().getValue() + " / " + cop +
                    " Discount: " + product.getDiscount());
        }
    }
    public void showProducts(List<Category> categories){
        for(Category category : categories){
            List<Product> allProducts = category.getProductList();
            getProducts(allProducts);
        }
    }
    public void listProducts(List<Category> categories){
        System.out.print("Category name: ");
        String categoryName = sc.nextLine();
        List<Product> allProducts = null;
        for(Category category : categories){
            if(category.getName().equals(categoryName) && category.getAvailable()){
                allProducts = category.getProductList();
                getProducts(allProducts);
            }
        }
        if(allProducts == null){
            System.out.println("Category doesn't exist");
        }
    }
    public void addProduct(List<Category> categories){
        boolean add = false;
        System.out.println("Category: ");
        String cat = sc.nextLine();
        for(Category category : categories){
            if (category.getName().equals(cat)) {
                add = true;
                break;
            }
        }
        if(add){
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Description: ");
            String description = sc.nextLine();
            System.out.println("Price: ");
            Double price = Double.valueOf(sc.nextLine());
            for(Category category : categories){
                if (category.getName().equals(cat)) {
                    category.getProductList().add(
                            new Product(name, description, cat, new Price(price, new Date()), new CrossedOutPrice(0.0))
                    );
                }
            }
        } else {
            System.out.println("Category doesn't exist");
        }
    }
}