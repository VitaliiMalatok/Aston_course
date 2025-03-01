package com.gmail.vitali.malatok;

public class Park {
    private final String name;
    private final String location;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    static class Attraction {
        private final String attractionName;
        private final String workingHours;
        private final double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "attractionName='" + attractionName + '\'' +
                    ", workingHours='" + workingHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
