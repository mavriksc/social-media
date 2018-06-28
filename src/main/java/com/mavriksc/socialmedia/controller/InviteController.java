package com.mavriksc.socialmedia.controller;

import com.mavriksc.socialmedia.dto.InviteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invite")
public class InviteController {

    @GetMapping
    public List<InviteDTO> listInvites() {
        return null;
    }

    @PostMapping
    public InviteDTO createInviteDTO(/* user maybe  */) {
        return null;
    }

    @GetMapping("/{uuid}")
    public Boolean isInvitationValid(@PathVariable("uuid") UUID uuid) {
        return false;
    }
}
