package com.mavriksc.socialmedia.repository;

import com.mavriksc.socialmedia.domain.StoredFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredFileRepository extends JpaRepository<StoredFile,Long> {
}
