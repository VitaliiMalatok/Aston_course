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
    }
}
