package org.octopusbaby.basketball.dto;

import java.io.Serializable;


public class UserDTO implements Serializable {

    private int id;

    private String userName;//用户名

    private String password;//用户密码

    private String userType;

    public UserDTO() {
    }

    public UserDTO(int id, String userName, String password, String userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
