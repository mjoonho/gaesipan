package com.gaesipan.gaesipan.controller;

import com.gaesipan.gaesipan.domain.comment.Comment;
import com.gaesipan.gaesipan.domain.comment.CommentRepository;
import com.gaesipan.gaesipan.domain.comment.CommentRequestDto;
import com.gaesipan.gaesipan.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/Comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("/api/Comments")
    public List<Comment> getComment() {
        return commentRepository.findAllByOrderByModifiedAtDesc();

    }


    @PutMapping("/api/Comments/{idC}")
    public Long updateComment(@PathVariable Long idC, @RequestBody CommentRequestDto requestDto){
        commentService.update(idC, requestDto);
        return idC;
    }

    @DeleteMapping("/api/Comments/{idC}")
    public Long deleteComment(@PathVariable Long idC) {
        commentRepository.deleteById(idC);
        return idC;
    }
}