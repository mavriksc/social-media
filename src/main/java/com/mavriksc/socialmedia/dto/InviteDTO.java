package com.mavriksc.socialmedia.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class InviteDTO {
    private UUID code;
    private Long id;
    private Date created;
    private Boolean used;

}
