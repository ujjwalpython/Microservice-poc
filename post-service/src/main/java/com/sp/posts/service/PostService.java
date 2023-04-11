package com.sp.posts.service;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPosts(PostDto postDto);

    PostDto getPost(Long postId);

    PostDto updatePost(PostDto postDto, Long postId);

    void deletePost(Long postId);

    List<Post> getUserPosts(String userId);
}
