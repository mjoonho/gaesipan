package com.gaesipan.gaesipan.service;


import com.gaesipan.gaesipan.domain.gaesipan.Gaesipan;
import com.gaesipan.gaesipan.domain.gaesipan.GaesipanRepository;
import com.gaesipan.gaesipan.domain.gaesipan.GaesipanRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GaesipanService {

    private final GaesipanRepository gaesipanRepository;

    @Transactional
    public long update(long id, GaesipanRequestDto requestDto) {
        Gaesipan gaesipan = gaesipanRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        gaesipan.update(requestDto);
        return gaesipan.getId();
    }
}
