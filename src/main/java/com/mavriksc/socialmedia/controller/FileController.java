package com.mavriksc.socialmedia.controller;

import com.mavriksc.socialmedia.dto.FileDTO;
import com.mavriksc.socialmedia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping
    public List<FileDTO> getFiles(/* user */) {
        return null;
    }

    @PostMapping
    public FileDTO newFile(/* user filename and data and tags*/) {
        return null;
    }

    @GetMapping("/user/{username}")
    public List<FileDTO> getUsersFileList(@PathVariable("username") String username) {
        return null;
    }

    @PutMapping("/{uuid}")
    public FileDTO updateFileTags(@PathVariable("uuid") UUID uuid  /* user fileDTO or tag list*/) {
        return null;
    }

    @GetMapping("/search")
    public List<FileDTO> searchFiles(@RequestParam("q") String querry) {
        return null;
    }

    @GetMapping("/{uuid}")
    public FileDTO downloadFile(@PathVariable("uuid") UUID uuid  /* user */) {
        return null;
    }

    @DeleteMapping("/{uuid}")
    public boolean deleteFile(@PathVariable("uuid") UUID uid) {
        return false;
    }
}
