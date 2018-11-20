package cn.mrlong.androidmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 授权
 */
public class Auther extends Authenticator {
    String username = null;
    String password = null;

    public Auther() {
    }

    public Auther(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

}
