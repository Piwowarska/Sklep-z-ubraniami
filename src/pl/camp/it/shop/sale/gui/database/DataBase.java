package pl.camp.it.shop.sale.gui.database;


import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.shop.sale.gui.database.authenticator.Authenticator;
import pl.camp.it.shop.sale.model.Shop;
import pl.camp.it.shop.sale.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final DataBase instance=new DataBase();
    private List<Shop> shop = new ArrayList<>(6);
    private List <User> users=new ArrayList<>();

    private DataBase() {
        this.shop.add(new Shop("Bluzka", 12, 1));
        this.shop.add( new Shop("Marynarka",  5, 2));
        this.shop.add( new Shop("Spodnie",  7, 3));
        this.shop.add( new Shop("Spodnica",  2, 4));
        this.shop.add( new Shop("Buty",  4, 5));
        this.shop.add( new Shop("Koszula",  9, 6));

        this.users.add(new User("login", DigestUtils.md5Hex(Authenticator.MD5_SEED+"login")));
        this.users.add(new User("hasło",DigestUtils.md5Hex(Authenticator.MD5_SEED+"hasło")));

    }

    public Shop kupProdukt(int numer) {
        Shop shop = this.findNumerProduktu(numer);
        if (shop== null || shop.getGuantity() == 0) {
            return null;
        } else {
            return shop;

        }
    }
        public Shop findNumerProduktu ( int numer){
            for (Shop produkt : this.shop) {
                if (produkt.getNumer() == numer) {
                    return produkt;
                }
            }
            return null;

        }
        public User gstUserByLogin(String login) {
            for (User user : this.users) {
                if (user.getLogin().equals(login)) {
                    return user;
                }
            }
            return null;
        }

        public List<Shop> getShop () {
            return shop;
        }

        public static DataBase getInstance(){
        return instance;
        }
    }


