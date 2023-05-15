package com.ezefm.informatorio2023.board.escenario2.utils;

import com.ezefm.informatorio2023.board.escenario2.entity.CrossedOutPrice;
import com.ezefm.informatorio2023.board.escenario2.entity.Price;
import com.ezefm.informatorio2023.board.escenario2.entity.Product;

import java.util.Date;
import java.util.List;

public class AddProducts {
    public void addToys(List<Product> toysList){
        toysList.add(new Product("Anakin Skywalker's lightsaber",
                "Exact replica of the lightsaber used by Anakin Skywalker. Includes sound and light effects.",
                "Toys",
                new Price(1500.0, new Date()),
                new CrossedOutPrice(2000.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("Lego Millennium Falcon",
                "It's a construction set of Han Solo's famous ship. It includes miniatures of the movie's characters.",
                "Toys",
                new Price(200.0, new Date()),
                new CrossedOutPrice(300.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("Lego Death Star",
                "The Death Star construction set is a highly detailed Lego game that allows you to build the iconic space station. It features accurate details and includes miniature versions of ships and characters from the movie",
                "Toys",
                new Price(300.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("Remote Control Millennium Falcon",
                "Is a scale replica of the iconic Star Wars spaceship. It features a remote control for easy maneuvering and comes with impressive light and sound effects, bringing the ship to life.",
                "Toys",
                new Price(300.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("The Darth Vader action figure",
                "The high-quality Darth Vader action figure is a premium collectible that showcases precise details of the iconic Star Wars character. It offers exceptional craftsmanship, intricate sculpting, and interchangeable accessories such as multiple hands, lightsabers, and a removable helmet.",
                "Toys",
                new Price(50.0, new Date()),
                new CrossedOutPrice(100.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("Lego Kylo Ren's ship",
                "The Kylo Ren's ship construction set is a detailed Lego game that allows you to build the iconic spacecraft from the Star Wars movies. It features precise details and includes miniature versions of characters from the film, providing an immersive experience while building and playing.",
                "Toys",
                new Price(150.0, new Date()),
                new CrossedOutPrice(347.0, new Date(), new Date(2023, 12, 31))
        ));
        toysList.add(new Product("Yoda Funk Pop",
                "The Yoda vinyl figure from the Funk Pop line is a collectible with a caricature-like design and precise details. It showcases the beloved Star Wars character in a cute and stylized form, making it a popular choice among fans and collectors.",
                "Toys",
                new Price(10.0, new Date()),
                new CrossedOutPrice(15.0, new Date(), new Date(2023, 12, 31))
        ));
    }

    public void addCollectibles(List<Product> collectiblesList){
        collectiblesList.add(new Product("Boba Fett's Helmet",
                "The replica of Boba Fett's iconic helmet is a highly detailed collectible that accurately portrays the Mandalorian bounty hunter's distinctive headgear. It features precise details and an adjustable visor, allowing fans to customize the look and recreate their favorite scenes from the Star Wars universe.",
                "Collectibles",
                new Price(800.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
        collectiblesList.add(new Product("X-wing of Luke Skywalker",
                "The X-wing of Luke Skywalker is a Lego construction set that allows you to build the famous starfighter from the Star Wars universe. It features the iconic design of Luke's X-wing, complete with intricate details, movable parts such as wings, and includes a mini-figure of Luke Skywalker himself.",
                "Collectibles",
                new Price(500.0, new Date()),
                new CrossedOutPrice(250.0, new Date(), new Date(2023, 12, 31))
        ));
        collectiblesList.add(new Product("Darth Vader's Helmet",
                "The replica of Darth Vader's iconic helmet is a high-quality collectible that faithfully recreates the menacing headgear of the Sith Lord. It features precise detailing, capturing the distinct design of the helmet, and includes an integrated voice and breathing system. With the voice modulation and breathing sound effects, wearing this helmet immerses you in the dark side of the Force, allowing you to feel the power of Darth Vader.",
                "Collectibles",
                new Price(600.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
        collectiblesList.add(new Product("Boba Fett's Slave I",
                "The Slave I model is a scale replica of Boba Fett's iconic starship, known for its distinctive design and association with the renowned bounty hunter. This highly detailed collectible accurately captures the unique features of the Slave I, including its rotating cockpit, adjustable wings, and intricate interior. The model also includes miniature figures of characters from the film, adding to the immersive experience and allowing fans to recreate epic scenes from the Star Wars universe.",
                "Collectibles",
                new Price(400.0, new Date()),
                new CrossedOutPrice(500.0, new Date(), new Date(2023, 12, 31))
        ));
    }
    public void addClothingAndCostumes(List<Product> clothingAndCostumesList){
        clothingAndCostumesList.add(new Product("Stormtrooper Costume",
                "Complete custom-made Stormtrooper costume, with accurate details. It includes a helmet, armor, gloves, and boots.",
                "Clothing and Costumes",
                new Price(3000.0, new Date()),
                new CrossedOutPrice(5000.0, new Date(), new Date(2023, 12, 31))
        ));
        clothingAndCostumesList.add(new Product("Darth Vader Gloves",
                "Replica of the gloves used by Darth Vader, with accurate details and made from high-quality materials.",
                "Clothing and Costumes",
                new Price(100.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
    }
    public void addBooksAndMagazines(List<Product> booksAndMagazinesList){
        booksAndMagazinesList.add(new Product("Star Wars Art Book",
                "Star Wars saga art book, featuring illustrations and sketches of characters, spacecraft, and movie settings.",
                "Books and Magazines",
                new Price(60.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
    }
    public void addDecoration(List<Product> decorationList){
        decorationList.add(new Product("Star Wars Poster",
                "Full-color star wars poster, featuring original designs and accurate details",
                "Decoration",
                new Price(20.0, new Date()),
                new CrossedOutPrice(0.0, new Date(), new Date(2023, 12, 31))
        ));
        decorationList.add(new Product("Darth Vader Poster",
                "Full-color Darth Vader Poster, featuring original designs and accurate details",
                "Decoration",
                new Price(20.0, new Date()),
                new CrossedOutPrice(35.0, new Date(), new Date(2023, 12, 31))
        ));
    }
    public void addKitchenAndHome(List<Product> kitchenAndHomeList){
        kitchenAndHomeList.add(new Product("R2-D2 Mug",
                "Ceramic mug with a design of R2-D2 and accurate details. Ideal for fans of the saga.",
                "Kitchen and Home",
                new Price(15.0, new Date()),
                new CrossedOutPrice(35.0, new Date(), new Date(2023, 12, 31))
        ));
    }

}