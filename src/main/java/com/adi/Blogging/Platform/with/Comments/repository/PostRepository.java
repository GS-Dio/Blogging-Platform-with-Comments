package com.adi.Blogging.Platform.with.Comments.repository;

import com.adi.Blogging.Platform.with.Comments.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
