package com.adi.Blogging.Platform.with.Comments.web;

import com.adi.Blogging.Platform.with.Comments.domain.Post;
import com.adi.Blogging.Platform.with.Comments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post save(@RequestBody Post post){
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post){
        return postService.update(id,post);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }
}
