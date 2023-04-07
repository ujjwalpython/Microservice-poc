package com.sp.posts.service;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;
import com.sp.posts.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private static String USERID = "1L";
    private final PostRepository postRepository;
    @Override
    public Post createPosts(PostDto postDto) {
        Post post = Post.builder().
            title(postDto.getTitle()).
            description(postDto.getDescription()).
            userId(USERID).build();
        postRepository.save(post);
        return post;
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }
}
