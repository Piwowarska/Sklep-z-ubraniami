package pl.camp.it.shop.sale.model;

public class User {
    private String login;
    private String pasword;

    public User(String login, String pasword) {
        this.login = login;
        this.pasword = pasword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
