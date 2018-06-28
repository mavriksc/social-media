package com.mavriksc.socialmedia.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Invitation {
    @Id
    private Long id;
    private UUID code;
    private Date created;
    private Boolean used;

    public Invitation() {
        code = UUID.randomUUID();
        created = Calendar.getInstance().getTime();
        used = false;
    }
}
