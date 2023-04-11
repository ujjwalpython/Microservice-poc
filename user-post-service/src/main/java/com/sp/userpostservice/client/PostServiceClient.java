package com.sp.userpostservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service",fallbackFactory =PostClientFallBackFactory.class )
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

    @GetMapping("/user-posts/{userId}")
    List<Post> getUserPosts(@PathVariable String userId);
}
