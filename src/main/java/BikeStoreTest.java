import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BikeStoreTest {

    @Test
    public void testReadBicyclesFromXML() {
        String filePath = "src/main/java/Bicycles.xml";
        List<Bicycle> bicycles = BikeStore.readBicyclesFromXML(filePath);

        // Проверка количества прочитанных велосипедов
        Assertions.assertEquals(6, bicycles.size());

        // Проверка данных для каждого велосипеда
        Bicycle mountainBike = bicycles.get(0);
        Assertions.assertEquals("Mountain Bike", mountainBike.getName());
        Assertions.assertEquals(500, mountainBike.getPrice());
        Assertions.assertEquals(10, mountainBike.getQuantity());

        Bicycle roadBike = bicycles.get(1);
        Assertions.assertEquals("Road Bike", roadBike.getName());
        Assertions.assertEquals(800, roadBike.getPrice());
        Assertions.assertEquals(5, roadBike.getQuantity());

        Bicycle cityBike = bicycles.get(2);
        Assertions.assertEquals("City Bike", cityBike.getName());
        Assertions.assertEquals(300, cityBike.getPrice());
        Assertions.assertEquals(8, cityBike.getQuantity());

        Bicycle electricBike = bicycles.get(3);
        Assertions.assertEquals("Electric Bike", electricBike.getName());
        Assertions.assertEquals(1200, electricBike.getPrice());
        Assertions.assertEquals(3, electricBike.getQuantity());

        DiscountedBicycle hybridBike = (DiscountedBicycle) bicycles.get(4);
        Assertions.assertEquals("Hybrid Bike", hybridBike.getName());
        Assertions.assertEquals(900, hybridBike.getPrice());
        Assertions.assertEquals(2, hybridBike.getQuantity());
        Assertions.assertEquals(10, hybridBike.getDiscount());


        
        hybridBike = (DiscountedBicycle) bicycles.get(4);
        Assertions.assertEquals("Hybrid Bike", hybridBike.getName());
        Assertions.assertEquals(900, hybridBike.getPrice());
        Assertions.assertEquals(2, hybridBike.getQuantity());
        Assertions.assertEquals(10, hybridBike.getDiscount());
    }


}
