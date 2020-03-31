package com.task.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "user")
@Entity
public class User // implements UserDetails {
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERID")
    private String userId;
    @Column(name = "PROFILENAME")
    private String profileName;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private String password;
/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList((GrantedAuthority) this::getRole);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return profileName;
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

 */
}
