package com.example.youtube2.repository;

import com.example.youtube2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository extends JpaRepository<Video,Long> {
    Iterable<Video> findAllByNameContaining(String name);

}
