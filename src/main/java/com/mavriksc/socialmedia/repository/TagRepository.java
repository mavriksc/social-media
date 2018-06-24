package com.mavriksc.socialmedia.repository;

import com.mavriksc.socialmedia.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByValue(String value);

}
