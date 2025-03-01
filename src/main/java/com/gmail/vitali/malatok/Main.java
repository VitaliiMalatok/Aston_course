package com.gmail.vitali.malatok;

public class Main {
    public static void main(String[] args) {
        //task_1
        Product murataConnectors = new Product("Murat_connectors", "12/2025", "Murata_corp", "Japan", 250, "reserved");
        System.out.println(murataConnectors);
        //task_2
        Product[] basicArray = new Product[5];
        basicArray[0] = new Product("MAX232", "12.01.2024", "Maxim Integrated", "USA", 350, "reserved");
        basicArray[1] = new Product("TSM101", "20.03.2024", "TSMC", "Taiwan", 180, "reserved");
        basicArray[2] = new Product("Murata GRM32ER", "05.06.2023", "Murata", "Japan", 50, "reserved");
        basicArray[3] = new Product("NXP LPC1768", "15.09.2024", "NXP Semiconductors", "Netherlands", 730, "reserved");
        basicArray[4] = new Product("Texas Instruments TPS61021A", "10.02.2025", "Texas Instruments", "USA", 290, "reserved");
        for (Product product : basicArray) {
            System.out.println(product);;
        }
        //task_3
        Park park = new Park("Energylandia", "Zator, Poland");
        Park.Attraction attraction1 = new Park.Attraction("Hyperion", "10:00 - 22:00", 50.00);
        Park.Attraction attraction2 = new Park.Attraction("Zadra", "11:00 - 21:00", 45.00);
        Park.Attraction attraction3 = new Park.Attraction("Mayan", "09:30 - 20:30", 35.00);
        Park.Attraction attraction4 = new Park.Attraction("Formula", "10:30 - 22:30", 40.00);
        Park.Attraction attraction5 = new Park.Attraction("Dragon Roller Coaster", "09:00 - 21:00", 30.00);
        System.out.println(park);
        System.out.println(attraction1);
        System.out.println(attraction2);
        System.out.println(attraction3);
        System.out.println(attraction4);
        System.out.println(attraction5);
    }
}
