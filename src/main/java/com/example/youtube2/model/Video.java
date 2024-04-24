package com.example.youtube2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String description;
   @ManyToOne
    @JoinColumn(name="category_id")


    private Category category;

//    @CreatedDate
//    @Column(name="create_at",nullable = false,updatable = false)
//private LocalDateTime createdAt;
//    @Column(name="updated_at")
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

}
