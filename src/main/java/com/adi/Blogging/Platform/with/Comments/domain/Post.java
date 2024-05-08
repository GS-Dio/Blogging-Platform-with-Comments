package com.adi.Blogging.Platform.with.Comments.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.Page;

import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String heading;
    private String content;
    private String imageUrl;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
