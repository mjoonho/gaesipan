package com.gaesipan.gaesipan.controller;

import com.gaesipan.gaesipan.domain.comment.Comment;
import com.gaesipan.gaesipan.domain.comment.CommentRepository;
import com.gaesipan.gaesipan.domain.comment.CommentRequestDto;

import com.gaesipan.gaesipan.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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



//@Configuration 참고용인데 어디다 저장할지 몰라서 그냥 여기다가 넣음
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .antMatchers("/h2-console/**");
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .ignoringAntMatchers("/user/**");
//
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        // 어떤 요청이든 '인증'
//                        .antMatchers("/images/**").permitAll()
//                        .antMatchers("/css/**").permitAll()
//                        .antMatchers("/user/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                // 로그인 기능 허용
//                .formLogin()
//                .loginPage("/user/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/user/login?error")
//                .permitAll()
//                .and()
//                //로그아웃 기능 허용
//                .logout()
//                .permitAll();
//
//        return http.build();
//    }
//}