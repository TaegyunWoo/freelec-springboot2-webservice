package com.my.springboot.web;

import com.my.springboot.domain.posts.PostsRepository;
import com.my.springboot.domain.posts.PostsService;
import com.my.springboot.web.dto.PostsReponseDto;
import com.my.springboot.web.dto.PostsSaveRequestDto;
import com.my.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsReponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
