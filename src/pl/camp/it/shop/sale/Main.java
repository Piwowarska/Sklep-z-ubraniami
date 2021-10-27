package pl.camp.it.shop.sale;

import pl.camp.it.shop.sale.gui.database.DataBase;
import pl.camp.it.shop.sale.gui.Gui;
import pl.camp.it.shop.sale.gui.database.authenticator.Authenticator;
import pl.camp.it.shop.sale.model.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DataBase dataBase=DataBase.getInstance();
        Gui gui=Gui.getInstance();
        Authenticator authenticator=Authenticator.getInstanceee();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
/*
        for(int i=0;i<3;i++) {

            System.out.println("Login");
            String login = reader.readLine();
            System.out.println("Password");
            String password = reader.readLine();

            if (!authenticator.authenticate(login, password, dataBase)) {
                System.out.println("Nieprawidłowe dane");
            }else{
                break;
            }
            if(i==2){
                return;
            }
        }

 */

        while (true){

            gui.showMenu();

            Scanner scanner=new Scanner(System.in);
            String number=reader.readLine();
            switch(number) {
                case "1":
                    for (Shop shop : dataBase.getShop()) {
                        System.out.println(shop);
                        }

                    break;

                case "2":
                    for(int i=0;i<3;i++) {

                        System.out.println("Login");
                        String login = reader.readLine();
                        System.out.println("Password");
                        String password = reader.readLine();

                        if (!authenticator.authenticate(login, password, dataBase)) {
                            System.out.println("Nieprawidłowe dane");
                        }else{
                            break;
                        }
                        if(i==2){
                            return;
                        }
                    }

                    System.out.println("Podaj numer produktu");
                    int numer = scanner.nextInt();
                    Shop shop = dataBase.kupProdukt(numer);
                    if (shop == null) {
                        System.out.println("Nie ma takiego produktu ");
                    } else {

                        System.out.println("Podaj ilosc sztuk");
                        int iloscSztuk = scanner.nextInt();

                        if (shop.getGuantity() >= iloscSztuk) {
                            int pom = shop.getGuantity() - iloscSztuk;
                            shop.setGuantity(pom);
                            System.out.println("Kupiles produkt");
                        } else {
                            System.out.println("Nie wystarczajaca ilosc sztuk w magazynie");
                        }
                    }
              break;

                case"3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Zly numer menu");

            }

        }

    }
}
