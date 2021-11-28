package pl.camp.it.shop.sale.gui.database.authenticator;


import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.shop.sale.gui.database.DataBase;
import pl.camp.it.shop.sale.model.User;

public class Authenticator {
    public static final String MD5_SEED="fgghjfbrt55u6786iuzvfhfjhjttstrh45";
    private static final Authenticator instancee=new Authenticator();

    private Authenticator() {
    }

    public boolean authenticate(String login, String password, DataBase dataBase){
        User user=dataBase.gstUserByLogin(login);
        return user !=null && user.getPasword().equals(DigestUtils.md5Hex(MD5_SEED+password));
    }
    public static Authenticator getInstanceee(){
        return instancee;
    }
}
