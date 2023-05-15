package com.ezefm.informatorio2023.board.escenario2.utils;

import com.ezefm.informatorio2023.board.escenario2.entity.Category;

import java.util.List;

public class Utils {

    AddCategories addCategories = new AddCategories();
    AddProducts addProducts = new AddProducts();
    public List<Category> fillCategories(){
        return addCategories.categories();
    }
    public void fillProducts(List<Category> categories){
        for(Category category : categories){
            switch (category.getName()){
                case "Toys" -> addProducts.addToys(category.getProductList());
                case "Collectibles" -> addProducts.addCollectibles(category.getProductList());
                case "Clothing and Costumes" -> addProducts.addClothingAndCostumes(category.getProductList());
                case "Decoration" -> addProducts.addDecoration(category.getProductList());
                case "Books and Magazines" -> addProducts.addBooksAndMagazines(category.getProductList());
                case "Kitchen and Home" -> addProducts.addKitchenAndHome(category.getProductList());
            }
        }
    }

}
