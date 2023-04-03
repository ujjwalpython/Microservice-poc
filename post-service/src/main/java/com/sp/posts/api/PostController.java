package com.sp.posts.api;

import com.sp.posts.domain.Post;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class PostController {

    private Environment env;

    public PostController(Environment env) {
        this.env = env;
    }

    @GetMapping(path = "/")
    public String home() {
        return "Hello from Post Service running at port:  :)))" + env.getProperty("local.server.port");
    }

    @GetMapping(path = "/posts")
    public List<Post> posts() {
        List<Post> posts = Arrays.asList(
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(1L, "The Town 2", "Treehouse of Horror V", "XXX"),
            new Post(2L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(3L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(4L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(5L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(6L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(7L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(8L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(9L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(10L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(11L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(12L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(13L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(14L, "Treehouse of Horror V", "Treehouse of Horror V", "XXX"),
            new Post(15L, "The Last Traction Hero", "Treehouse of Horror V", "XXX"));

        return posts;

    }


}
