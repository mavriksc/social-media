package com.mavriksc.socialmedia.repository;

import com.mavriksc.socialmedia.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
