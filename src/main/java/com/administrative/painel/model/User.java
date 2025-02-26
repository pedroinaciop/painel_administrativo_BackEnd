package com.administrative.painel.model;

import com.administrative.painel.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity(name = "users")
@EqualsAndHashCode(of = "user_id")

//UserDetails, interface que nos auxilia na administração dos usuários.
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 60)
    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private UserRole role;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date updateDate;

    private String updateUser;

    public User() {}

    public User(Long user_id, String fullName, String email, String password, UserRole role) {
        this.user_id = user_id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(UserDTO dados) {
        this.user_id = dados.user_id();
        this.fullName = dados.fullName();
        this.email = dados.email();
        this.password = dados.password();
        this.role = dados.role();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
    }

    public User(String fullName, String login, String encryptedPassword, Date updateDate, UserRole role) {
        this.fullName = fullName;
        this.email = login;
        this.password = encryptedPassword;
        this.updateDate = updateDate;
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    //Métodos do UserDetails

    @Override
    public String getUsername() {
        return email;
    }

    //Se for ADMIN, ele tem duas permissões: ROLE_ADMIN e ROLE_USER.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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