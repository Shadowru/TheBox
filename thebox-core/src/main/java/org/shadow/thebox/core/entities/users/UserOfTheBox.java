package org.shadow.thebox.core.entities.users;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserOfTheBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userID;

    @Column(unique = true, nullable = false)
    String login;

    @Column(nullable = false)
    String pwdHash;

    String userName;
    String userSurname;
    String userPatronimyc;

    @OneToMany(fetch=FetchType.EAGER)
    List<Role> roles;

    public int getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPatronimyc() {
        return userPatronimyc;
    }

    public void setUserPatronimyc(String userPatronimyc) {
        this.userPatronimyc = userPatronimyc;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
