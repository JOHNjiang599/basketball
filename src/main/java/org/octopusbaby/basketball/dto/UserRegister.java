package org.octopusbaby.basketball.dto;

public class UserRegister {

    private String userName;

    private String password;

    private String repassword;

    public UserRegister() {
    }

    public UserRegister(String userName, String password, String repassword) {
        this.userName = userName;
        this.password = password;
        this.repassword = repassword;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }
}
