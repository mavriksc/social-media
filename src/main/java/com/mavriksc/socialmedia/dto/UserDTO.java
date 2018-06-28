package com.mavriksc.socialmedia.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private UUID invite;
    private String username;
    private String password;
    private String passwordRetype;
}
