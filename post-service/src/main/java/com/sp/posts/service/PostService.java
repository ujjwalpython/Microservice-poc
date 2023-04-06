package com.sp.posts.service;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;

public interface PostService {
    Post createPosts(PostDto postDto);

    Post getPost(Long postId);
}
