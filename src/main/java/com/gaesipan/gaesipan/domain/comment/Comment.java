package com.gaesipan.gaesipan.domain.comment;

import com.gaesipan.gaesipan.domain.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String cname;

    @Column(nullable = false)
    private String cpw;

    @Column(nullable = false)
    private String cid;

    @Column(nullable = false)
    private long id;



    public Comment( String comment, String cname, String cpw, String cid, long id) {
        this.cname = cname;
        this.comment =comment;
        this.cpw = cpw;
        this.cid = cid;
        this.id = id;
    }

    public Comment(CommentRequestDto requestDto) {
        this.cname = requestDto.getCname();
        this.comment = requestDto.getComment();
        this.cpw = requestDto.getCpw();
        this.cid = requestDto.getCid();
        this.id = requestDto.getId();
    }

    public void update(CommentRequestDto requestDto) {
        this.cname = requestDto.getCname();
        this.comment = requestDto.getComment();
        this.cpw = requestDto.getCpw();
        this.cid = requestDto.getCid();
        this.id = requestDto.getId();
    }
}