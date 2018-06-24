package com.mavriksc.socialmedia.dto;

import com.mavriksc.socialmedia.domain.Tag;
import com.mavriksc.socialmedia.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FileDTO {
    private List<Tag> tags;
    private User owner;
    private String filename;

}
