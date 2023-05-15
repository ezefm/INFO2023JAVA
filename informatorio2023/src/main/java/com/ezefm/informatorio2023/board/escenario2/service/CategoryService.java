package com.ezefm.informatorio2023.board.escenario2.service;

import com.ezefm.informatorio2023.board.escenario2.entity.Category;
import com.ezefm.informatorio2023.board.escenario2.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CategoryService {

    private final Scanner sc = new Scanner(System.in);

    public void addCategory(List<Category> categories){
        Category category = new Category();
        List<Product> list = new ArrayList<>();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Description: ");
        String description = sc.nextLine();
        Boolean available = sc.nextBoolean();
        category.setName(name);
        category.setDescription(description);
        category.setAvailable(available);
        category.setProductList(list);
        categories.add(category);
    }

    public void modifyCategory(){}

    public void deleteCategory(){}

}