package com.michalsniezko.jpa_course.repositories;

import com.michalsniezko.jpa_course.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
