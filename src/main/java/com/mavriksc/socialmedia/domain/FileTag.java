package com.mavriksc.socialmedia.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileTag {
    @EmbeddedId
    private FileTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fileId")
    private StoredFile file;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    private Tag tag;

    public FileTag(StoredFile file, Tag tag) {
        this.file = file;
        this.tag = tag;
        this.id = new FileTagId(file.getId(), tag.getId());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        FileTag that = (FileTag) o;
        return Objects.equals(file, that.file) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file.getUuid(), tag.getValue());
    }



}
