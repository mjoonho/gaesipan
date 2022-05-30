package com.gaesipan.gaesipan.service;

import com.gaesipan.gaesipan.domain.Comment;
import com.gaesipan.gaesipan.domain.CommentRepository;
import com.gaesipan.gaesipan.domain.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public long update(long idC, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(idC).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }
}