package com.gaesipan.gaesipan.domain.gaesipan;

import com.gaesipan.gaesipan.domain.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Gaesipan extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    //id 자동 생성 밑 증가

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pw;

    public Gaesipan(String title, String contents, String name, String pw) {
        this.name = name;
        this.title = title;
        this.contents =contents;
        this.pw = pw;
    }

    public Gaesipan(GaesipanRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.name = requestDto.getName();
        this.pw = requestDto.getPw();
    }

    public void update(GaesipanRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.pw = requestDto.getPw();
    }
}



