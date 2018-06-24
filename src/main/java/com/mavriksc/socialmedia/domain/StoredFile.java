package com.mavriksc.socialmedia.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
public class StoredFile {
    @Id
    @GeneratedValue
    private Long id;

    private String filename;
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User owner;

    @Transient
    private Set<Tag> userTags;

    @OneToMany(
        mappedBy = "file",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Set<FileTag> allTags = new HashSet<>();

    public void addTag(Tag tag){
        FileTag fileTag = new FileTag(this,tag);
        allTags.add(fileTag);
        tag.getFiles().add(fileTag);
    }

    public void removeTag(Tag tag) {
        for (Iterator<FileTag> iterator = allTags.iterator();
             iterator.hasNext(); ) {
            FileTag fileTag = iterator.next();

            if (fileTag.getFile().equals(this) &&
                    fileTag.getTag().equals(tag)) {
                iterator.remove();
                fileTag.getTag().getFiles().remove(fileTag);
                fileTag.setFile(null);
                fileTag.setTag(null);
            }
        }
    }

    public Set<Tag> getUserTags() {
        if (userTags == null) {
            userTags = new HashSet<>(allTags.stream()
                    .filter(ft -> ft.getTag().getType() == TagType.USER)
                    .map(ft-> new Tag(ft.getTag().getValue()))
                    .collect(Collectors.toSet()));
            return userTags;
        } else {
            return userTags;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        StoredFile file = (StoredFile) o;
        return Objects.equals(uuid, file.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }


}
