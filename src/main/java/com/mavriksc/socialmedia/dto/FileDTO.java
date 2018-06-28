package com.mavriksc.socialmedia.dto;

import com.mavriksc.socialmedia.domain.StoredFile;
import com.mavriksc.socialmedia.domain.Tag;
import com.mavriksc.socialmedia.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class FileDTO {
    private Long id;
    private UUID uuid;
    private List<Tag> tags;
    private User owner;
    private String filename;



    public FileDTO(StoredFile file){
        id = file.getId();
        uuid = file.getUuid();
        tags = new ArrayList<>(file.getUserTags());
        owner = file.getOwner();
        filename = file.getFilename();
    }

    public FileDTO() {

    }
}
