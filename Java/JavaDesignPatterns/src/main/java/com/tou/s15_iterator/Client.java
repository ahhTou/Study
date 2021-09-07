package com.tou.s15_iterator;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<College> colleges = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        colleges.add(computerCollege);
        colleges.add(infoCollege);

        new OutputImpl(colleges).printCollege();
    }
}
