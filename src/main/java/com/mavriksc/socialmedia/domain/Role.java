package com.mavriksc.socialmedia.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }

    public Role(Roles role) {
        this.role = role.toString();
    }

    public Role(){

    };

    public enum Roles{
        ADMIN,USER
    }

}
