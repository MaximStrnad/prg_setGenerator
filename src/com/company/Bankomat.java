package com.company;
import java.util.Date;
import java.util.Scanner;

public class Bankomat {
    private int penize;
    private int ctiPin(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private boolean overPIN(int pin){
        return pin == 1234;
    }

    void setPenize(int kolik){
        Date d = new Date();
        if(kolik>0){
            penize += kolik;
            System.out.println(d + " vlozeno: " + kolik);
        }
        else{
            System.out.println(d + " podezrely vklad: " + kolik);
        }
    }

    void vyberPenize(int kolik){
        Date d = new Date();

        int pocetPokusu = 0;

        while(pocetPokusu <3){
            System.out.println("Zadejte svuj PIN: ");
            int pin = ctiPin();

            if(overPIN(pin)){
                if(penize >= kolik){

                    penize -= kolik;
                    System.out.println(d + " z uctu vybrano: " + kolik);
                }
                else{
                    System.out.println("Nedostatek hotovosti na ucte!");
                }
                pocetPokusu = 3;
            }
            else{
                System.out.println(d + " PIN nesouhlasi");
                pocetPokusu++;
            }
        }
    }

    int getPenize(){
        Date d = new Date();
        System.out.println("Zadejte svuj PIN: ");
        int pin = ctiPin();

        if(overPIN(pin)){
            return penize;
        }
        else{
            System.out.println(d + " zadany PIN nesouhlasi");
        }
        return 0;
    }
    void performAction () {
        System.out.println("Zmackni 1 pro vlozeni, 2 pro vybrani, 3 vypsat stav, 4 odejit: ");
        Scanner sc = new Scanner(System.in);
        int actionNumber =  sc.nextInt();
        switch(actionNumber) {
            case 1:
                break;


        }

    }
}
