package com.hiamitchaurasia.example1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Post {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @NonNull
    public String title;
    @NonNull
    public String content;
    @NonNull
    public String author;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Comment1> comments;

}
