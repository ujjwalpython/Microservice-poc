package com.sp.userpostservice.api;

import com.sp.userpostservice.client.PostServiceClient;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        return "Hello from User Post Service running at port: " + env.getProperty("local.server.port");
    }

    @GetMapping(path = "{id}/posts")
    public List<Object> getPosts(@PathVariable String id) {
        return this.postServiceClient.getAll();
    }
}
