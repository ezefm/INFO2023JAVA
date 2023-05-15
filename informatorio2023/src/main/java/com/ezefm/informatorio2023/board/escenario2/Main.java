package com.ezefm.informatorio2023.board.escenario2;

import com.ezefm.informatorio2023.board.escenario2.entity.Category;
import com.ezefm.informatorio2023.board.escenario2.entity.Product;
import com.ezefm.informatorio2023.board.escenario2.service.ProductService;
import com.ezefm.informatorio2023.board.escenario2.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utils util = new Utils();
        ProductService productService = new ProductService();
        List<Category> categories = util.fillCategories();
        List<Product> allProductsOrderByPrice = new ArrayList<>();
        util.fillProducts(categories);
        int op;
        do{
            System.out.print("""
                    1. List the five most cheapest products.
                    2. List the five most expensive products.
                    3. Show products.
                    4. List products.
                    5. Add Product.
                    6. Exit.
                    Option:
                    """);
            op = Integer.parseInt(sc.next());
            switch(op){
                case 1 -> productService.showFiveProducts(categories, allProductsOrderByPrice, 2);
                case 2 -> productService.showFiveProducts(categories, allProductsOrderByPrice, 1);
                case 3 -> productService.showProducts(categories);
                case 4 -> productService.listProducts(categories);
                case 5 -> productService.addProduct(categories);
            }
        }while(op != 6);
    }
}