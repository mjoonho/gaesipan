package com.gaesipan.gaesipan.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();

    List<Comment> findByIdOrderByModifiedAtDesc(long id);
}