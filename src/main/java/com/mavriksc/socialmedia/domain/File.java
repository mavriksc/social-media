package com.mavriksc.socialmedia.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false,exclude = "tags")
public class File {
    @Id
    @GeneratedValue
    private Long id;

    private String filename;
    private String uuid;
    private String tags;

}
