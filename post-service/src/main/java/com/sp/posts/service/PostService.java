package com.sp.posts.service;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;

public interface PostService {
    PostDto createPosts(PostDto postDto);

    PostDto getPost(Long postId);

    PostDto updatePost(PostDto postDto, Long postId);

    void deletePost(Long postId);
}
