package com.avtopark.Controller;

public enum ConfigPath {
    home("/home.jsp"),
    login("/login.jsp"),
    profile("/profile.jsp"),
    employments("/employments.jsp"),
    users("/users.jsp"),
    buses("/buses.jsp"),
    routes("/routes.jsp")
    ;
    private final String jspPath;
    ConfigPath(String jspPath){
        this.jspPath = jspPath;
    }

    public String getJspPath() {
        return jspPath;
    }
}
