package com.sp.userpostservice.api;

import com.sp.userpostservice.client.Post;
import com.sp.userpostservice.client.PostServiceClient;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "/")
public class UserPostController {

    private final Environment env;
    private final PostServiceClient postServiceClient;

    public UserPostController(Environment env, PostServiceClient postServiceClient) {
        this.env = env;
        this.postServiceClient = postServiceClient;
    }

    @GetMapping(path = "/")
    public String home() {
        log.info("api success!!!!!!!!!!!!!!!");
        return "Hello from User Post Service running at port: " + env.getProperty("local.server.port");
    }

    @GetMapping(path = "{id}/posts")
    public List<Post> getPosts(@PathVariable String id) {
        return this.postServiceClient.getUserPosts(id);
    }

    @GetMapping(path = "/posts/{postId}")
    public Post getPostsById(@PathVariable Long postId) {
        return this.postServiceClient.getPost(postId);
    }

    @DeleteMapping(path = "/posts/{postId}")
    public void deletePostsById(@PathVariable Long postId) {
         this.postServiceClient.deletePost(postId);
    }

}
