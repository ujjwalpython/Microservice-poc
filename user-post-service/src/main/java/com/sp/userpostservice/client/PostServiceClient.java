package com.sp.userpostservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "post-service")
public interface PostServiceClient {

    @GetMapping("/posts")
    List<Object> getAll();

    @PostMapping("/posts")
    Post addPost(@RequestBody Post post);

    @GetMapping("/posts/{id}")
    Post getPost(@PathVariable long id);

    @PutMapping("/posts/{id}")
    void updatePost(@PathVariable long id, @RequestBody Post post);

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable long id);
}
