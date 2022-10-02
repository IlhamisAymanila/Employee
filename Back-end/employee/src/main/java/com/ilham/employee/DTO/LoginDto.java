package com.ilham.employee.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilham.employee.Model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LoginDto implements UserDetails {

    private long id;

    private String username;

    @JsonIgnore
    private String password;

    public LoginDto(long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static LoginDto build(Employee employee){
        return new LoginDto(
                employee.getId(),
                employee.getName(),
                employee.getPassword()
        );
    }


    public long getId() {
        return id;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
