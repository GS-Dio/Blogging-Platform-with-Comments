package com.adi.Blogging.Platform.with.Comments.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
