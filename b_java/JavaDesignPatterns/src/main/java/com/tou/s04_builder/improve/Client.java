package com.tou.s4_builder.improve;

public class Client {

    public static void main(String[] args) {
        CommonHouseBuilder commonHouse = new CommonHouseBuilder();
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        House house = houseDirector.constructHouse();


        HighBuildingBuilder highBuilding = new HighBuildingBuilder();
        houseDirector.setHouseBuilder(highBuilding);
        houseDirector.constructHouse();
    }

}
