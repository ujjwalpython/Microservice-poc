package com.sp.userpostservice.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PostClientFallBackFactory implements FallbackFactory<PostServiceClient> {
    @Override
    public PostServiceClient create(Throwable cause) {
        log.error("An exception occurred when calling the UserSessionClient", cause);
        return new PostServiceClient() {
            @Override
            public List<Object> getAll() {
                return null;
            }

            @Override
            public Post addPost(Post post) {
                return null;
            }

            @Override
            public Post getPost(long id) {
                log.info("exception occured for the users post:{}",cause.getMessage());
                return new Post();
            }

            @Override
            public void updatePost(long id, Post post) {
                log.info("exception occured for the users post:{}",cause.getMessage());

            }

            @Override
            public void deletePost(long id) {
                log.info("exception occured for the users post:{}",cause.getMessage());
            }

            @Override
            public List<Post> getUserPosts(String userId) {
                log.info("exception occured for the users post:{}",cause.getMessage());
                return new ArrayList();
            }
        };
    }

}
