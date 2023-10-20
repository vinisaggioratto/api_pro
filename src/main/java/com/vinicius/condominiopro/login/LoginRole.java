package com.vinicius.condominiopro.login;

public enum LoginRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    LoginRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
