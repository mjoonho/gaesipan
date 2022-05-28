package com.gaesipan.gaesipan.controller;

import com.gaesipan.gaesipan.domain.Gaesipan;
import com.gaesipan.gaesipan.domain.GaesipanRepository;
import com.gaesipan.gaesipan.domain.GaesipanRequestDto;
import com.gaesipan.gaesipan.service.GaesipanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class GaesipanController {
    private final GaesipanRepository gaesipanRepository;
    private final GaesipanService gaesipanService;

    @PostMapping("/api/Gaesipans")
    public Gaesipan createBoard(@RequestBody GaesipanRequestDto requestDto) {
        Gaesipan gaesipan = new Gaesipan(requestDto);
        return gaesipanRepository.save(gaesipan);
    }

    @GetMapping("/api/Gaesipans")
    public List<Gaesipan> getGaesipan() {
        return gaesipanRepository.findAllByOrderByModifiedAtDesc();

    }

    @GetMapping("/api/Gaesipans/{id}")
    public Gaesipan getGaesipan(@PathVariable Long id) {
        Gaesipan gaesipan =  gaesipanRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("Id가 존재하지 않습니다."));
        return gaesipan;
    }

    @PutMapping("/api/Gaesipans/{id}")
    public Long updateGaesipan(@PathVariable Long id, @RequestBody GaesipanRequestDto requestDto){
        gaesipanService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/Gaesipans/{id}")
    public Long deleteGaesipan(@PathVariable Long id) {
        gaesipanRepository.deleteById(id);
        return id;
    }
}
