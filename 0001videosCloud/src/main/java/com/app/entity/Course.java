package com.app.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter

@AllArgsConstructor
@ToString
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> videoUrls;

    // Constructors, getters, setters
    public Course() {}

    public Course(String name, List<String> videoUrls) {
        this.name = name;
        this.videoUrls = videoUrls;
    }

    
}
