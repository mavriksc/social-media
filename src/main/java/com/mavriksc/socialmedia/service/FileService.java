package com.mavriksc.socialmedia.service;

import com.mavriksc.socialmedia.domain.StoredFile;
import com.mavriksc.socialmedia.domain.Tag;
import com.mavriksc.socialmedia.dto.FileDTO;
import com.mavriksc.socialmedia.repository.StoredFileRepository;
import com.mavriksc.socialmedia.repository.TagRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class FileService {
    @Autowired
    private StoredFileRepository storedFileRepository;
    @Autowired
    private TagRepository tagRepository;


    @Transactional
    public void saveFile(FileDTO file) {
        log.info(String.format("Creating new File Named: %s", file.getFilename()));
        // create new tags;
        StoredFile newFile = new StoredFile();

        createNewTags(file).forEach(t -> newFile.addTag(t));
        newFile.setOwner(file.getOwner());
        newFile.setFilename(file.getFilename());
        storedFileRepository.save(newFile);
    }

    private List<Tag> createNewTags(FileDTO file) {
        List<Tag> tags = new ArrayList<>();

        file.getTags().forEach(tag -> {
            Tag findIt = tagRepository.findByValue(tag.getValue());
            if (findIt == null) {
                findIt = tagRepository.save(new Tag(tag.getValue()));
                log.info(String.format("Creating new Tag: %s", findIt.getValue()));
            }
            tags.add(findIt);
        });
        return tags;
    }
}
