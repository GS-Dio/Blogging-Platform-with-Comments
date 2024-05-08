package com.adi.Blogging.Platform.with.Comments.service;

import com.adi.Blogging.Platform.with.Comments.domain.Comment;
import com.adi.Blogging.Platform.with.Comments.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment update(Long id, Comment updateComment){
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isPresent()){
            Comment newComment = optionalComment.get();

            newComment.setText(updateComment.getText());
            newComment.setPost(updateComment.getPost());

            return newComment;
        }else
            log.warn("Comment " + id + " not found!");

        return null;
    }

    public Comment findById(Long id){
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isPresent()){
            return optionalComment.get();
        }else
            log.warn("Comment " + id + " not found!");
        return null;
    }

    public List<Comment> findAll(){
        List<Comment> comments = new LinkedList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }




    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
