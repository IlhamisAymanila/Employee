package com.ilham.employee.DTO;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private long id;
    private String username;
    private String email;

    public JwtResponse (String accessToken, long id, String username){
        this.token = accessToken;
        this.id=id;
        this.username = username;

    }




    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
