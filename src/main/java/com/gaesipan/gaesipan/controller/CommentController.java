package com.gaesipan.gaesipan.controller;

import com.gaesipan.gaesipan.domain.comment.Comment;
import com.gaesipan.gaesipan.domain.comment.CommentRepository;
import com.gaesipan.gaesipan.domain.comment.CommentRequestDto;
import com.gaesipan.gaesipan.domain.gaesipan.Gaesipan;
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

    @GetMapping("/api/Comments/{id}")
    public List<Comment> getComment(@PathVariable Long id) {
        return commentRepository.findByIdOrderByModifiedAtDesc(id);

    }

//    @GetMapping("/api/usernames/{username}/posts")
//    public List<Post> singlePost(@PathVariable String username){
//        return postRepository.findAllByUsername(username);
//    }

//    @GetMapping("/api/Gaesipans/{id}")
//    public Gaesipan getGaesipan(@PathVariable Long id) {
//        Gaesipan gaesipan =  gaesipanRepository.findById(id).orElseThrow(
//                ()->new IllegalArgumentException("Id가 존재하지 않습니다."));
//        return gaesipan;
//    }


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