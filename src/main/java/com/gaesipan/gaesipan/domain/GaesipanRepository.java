package com.gaesipan.gaesipan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GaesipanRepository extends JpaRepository<Gaesipan, Long> {
    List<Gaesipan> findAllByOrderByModifiedAtDesc();
}
