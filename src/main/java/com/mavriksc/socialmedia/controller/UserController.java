package com.mavriksc.socialmedia.controller;

import com.mavriksc.socialmedia.dto.UserDTO;
import com.mavriksc.socialmedia.dto.UserFilesDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @PostMapping
    public UserDTO createUser(UserDTO user /*  need invite also to validate  */) {
        return null;
    }

    @PutMapping
    public boolean updatePassword(UserDTO user) {
        return false;
    }

    @GetMapping
    public List<UserFilesDTO> getUsersInfo() {
        return null;
    }
}
