package com.adi.Blogging.Platform.with.Comments.service;

import com.adi.Blogging.Platform.with.Comments.domain.Post;
import com.adi.Blogging.Platform.with.Comments.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostService {
    @Autowired
    public final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post update(Long id, Post updatePost){
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()){
            Post newPost = optionalPost.get();

            newPost.setHeading(updatePost.getHeading());
            newPost.setContent(updatePost.getContent());
            newPost.setImageUrl(updatePost.getImageUrl());

            return newPost;
        }else
            log.warn("Post " + id + " not fount!");
        return null;
    }

    public Post findById(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()){
            return optionalPost.get();
        }else
            log.warn("Post " + id + " not fount!");
        return null;
    }

    public List<Post> findAll(){
        List<Post> posts = new LinkedList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }
}
