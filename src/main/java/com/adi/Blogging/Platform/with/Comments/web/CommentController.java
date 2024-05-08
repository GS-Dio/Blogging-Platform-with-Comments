package com.adi.Blogging.Platform.with.Comments.web;

import com.adi.Blogging.Platform.with.Comments.domain.Comment;
import com.adi.Blogging.Platform.with.Comments.domain.Post;
import com.adi.Blogging.Platform.with.Comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;






    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        return commentService.update(id,comment);
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
