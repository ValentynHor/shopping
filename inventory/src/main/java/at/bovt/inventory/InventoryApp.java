package at.bovt.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class InventoryApp {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApp.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//        return args -> {
//            var inventory = new Inventory();
//            inventory.setSkuCode("iphone_13_red");
//            inventory.setQuantity(100);
//
//            var inventory2 = new Inventory();
//            inventory2.setSkuCode("iphone_13_blue");
//            inventory2.setQuantity(0);
//
//            inventoryRepository.save(inventory);
//            inventoryRepository.save(inventory2);
//        };
//    }
}