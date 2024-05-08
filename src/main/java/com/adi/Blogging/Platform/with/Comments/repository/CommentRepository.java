package com.adi.Blogging.Platform.with.Comments.repository;

import com.adi.Blogging.Platform.with.Comments.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
