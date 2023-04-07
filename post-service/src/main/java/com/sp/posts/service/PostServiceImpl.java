package com.sp.posts.service;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;
import com.sp.posts.repo.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private static String USERID = "1L";
    private final PostRepository postRepository;

    @Override
    public PostDto createPosts(PostDto postDto) {
        Post post = Post.builder().
            title(postDto.getTitle()).
            description(postDto.getDescription()).
            userId(USERID).build();
        postRepository.save(post);

        return postDto.builder().
            title(post.getTitle())
            .postId(post.getId())
            .userId(post.getUserId())
            .description(post.getDescription()).build();
    }

    @Override
    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("post with id " + postId + " not exists"));
        return PostDto.builder().
            title(post.getTitle())
            .postId(post.getId())
            .userId(post.getUserId())
            .description(post.getDescription()).build();
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException("post with id " + postId + " not exists"));
    post.setTitle(postDto.getTitle());
    post.setDescription(postDto.getDescription());
    post = postRepository.save(post);

    return PostDto.builder().
            title(post.getTitle())
            .postId(post.getId())
            .userId(post.getUserId())
            .description(post.getDescription()).build();
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException("post with id " + postId + " not exists"));
        postRepository.delete(post);
    }
}
