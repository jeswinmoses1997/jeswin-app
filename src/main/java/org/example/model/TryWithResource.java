package org.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] argument) throws InvalidDaysException {
//        getPlayerScore("/Users/jeswin/Learn/myfirstwar/src/main/webapp/WEB-INF/TestRead.txt");
//        testTryWithResource();
//        testTour();
//        Domestic tourInterface=new Domestic();
        International tourInterface=new International();

        try {
            tourInterface.setCost(100);
            tourInterface.setDays(2);
            tourInterface.setName("mdu");
            testTour1(tourInterface);
        } catch (InvalidCostException e) {
            System.out.println(e.getMessage());
        } catch (InvalidDaysException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getPlayerScore(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            while (contents.hasNext()) {
                System.out.println(Integer.parseInt(contents.nextLine()));
            }
        } catch (FileNotFoundException e ) {
            System.out.println("File not found, resetting score.");
        }
    }
    public static void testTryWithResource(){
        try (Medical tablet=new Medical()){
            tablet.setName("dolo650");
            tablet.setClaim(90);
        } catch (Exception dolo){
            System.out.println("inside exception");
        }
    }
    public static void testRunTimeException(){
        Medical tonic=new Medical();
        tonic.setClaim(100);
    }
    public static void testTour() throws InvalidCostException {
        try (Domestic chennai=new Domestic()) {
            chennai.setName("Chennai");
            chennai.setDays(3);
            chennai.setCost(1000);
            System.out.println(chennai.getName());
            System.out.println(chennai.getDays());
            System.out.println(chennai.getCost());
        } catch (Exception chennai){
            System.out.println("hi");
        }
    }
    public static void testTour1(TourInterface tourInterface) throws InvalidCostException, InvalidDaysException {
        try (Domestic chennai=new Domestic()) {
            chennai.setName(tourInterface.getName());
            chennai.setDays(tourInterface.getDays());
            chennai.setCost(tourInterface.getCost());
            System.out.println(chennai.getName());
            System.out.println(chennai.getDays());
            System.out.println(chennai.getCost());
        } catch (Exception chennai){
            System.out.println("hi");
        }
    }
}
