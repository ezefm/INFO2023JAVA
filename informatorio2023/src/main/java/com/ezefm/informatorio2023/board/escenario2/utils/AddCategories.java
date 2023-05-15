package com.ezefm.informatorio2023.board.escenario2.utils;

import com.ezefm.informatorio2023.board.escenario2.entity.Category;
import com.ezefm.informatorio2023.board.escenario2.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class AddCategories {

    List<Product> toysList = new ArrayList<>();
    Category toys = new Category("Toys",
            "Action figures, vehicles, spaceships, and playsets that allow you to recreate scenes and battles from the Star Wars movies and series. Ideal for kids and collectors alike.",
            true,
            toysList
    );
    List<Product> collectiblesList = new ArrayList<>();
    Category collectibles = new Category("Collectibles",
            "Unique and limited edition pieces ranging from special edition figures to collectible items such as replica lightsabers, helmets, busts, and spaceship models.",
            true,
            collectiblesList
    );
    List<Product> clothingAndCostumesList = new ArrayList<>();
    Category clothingAndCostumes = new Category("Clothing and Costumes",
            "T-shirts, sweatshirts, jackets, caps, and costumes of Star Wars characters for fans of all ages. Perfect for themed events, conventions, and everyday wear.",
            true,
            clothingAndCostumesList
    );
    List<Product> booksAndMagazinesList = new ArrayList<>();
    Category booksAndMagazines = new Category("Books and Magazines",
            "Novels, comics, guides, encyclopedias, and magazines of Star Wars to delve deep into the expanded universe and its characters. Ideal for fans who want to immerse themselves in stories and details beyond the movies.",
            true,
            booksAndMagazinesList
    );
    List<Product> decorationList = new ArrayList<>();
    Category decoration = new Category("Decoration",
            "Posters, paintings, sculptures, lamps, and other decorative objects inspired by Star Wars to give a special and thematic touch to any room or space in your home.",
            true,
            decorationList
    );
    List<Product> kitchenAndHomeList = new ArrayList<>();
    Category kitchenAndHome = new Category("Kitchen and Home",
            "Cooking utensils, glasses, plates, mugs, and other accessories with Star Wars designs to add a fun touch to cooking and dining. Additionally, towels, cushions, and other objects to decorate and personalize your home.",
            true,
            kitchenAndHomeList
    );

    public List<Category> categories(){
        List<Category> categories = new ArrayList<>();
        categories.add(toys);
        categories.add(collectibles);
        categories.add(clothingAndCostumes);
        categories.add(booksAndMagazines);
        categories.add(decoration);
        categories.add(kitchenAndHome);
        return categories;
    }

}