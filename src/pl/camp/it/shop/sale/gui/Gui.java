package pl.camp.it.shop.sale.gui;

import pl.camp.it.shop.sale.model.Shop;

public class Gui {
    private static final Gui instance=new Gui();


    private Gui() {
    }

    public static void showMenu() {
        System.out.println("1. Lista ubran");
        System.out.println("2. Kup ubranie ");
        System.out.println("3. Wyjdz");
    }
    public static Gui getInstance(){
        return instance;
    }
}
