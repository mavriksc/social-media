package com.mavriksc.socialmedia.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false,exclude = "tags")
public class StoredFile {
    @Id
    @GeneratedValue
    private Long id;

    private String filename;
    private UUID uuid;
    private String tags;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User owner;

}
