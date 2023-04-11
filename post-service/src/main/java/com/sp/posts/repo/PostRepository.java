package com.sp.posts.repo;

import com.sp.posts.domain.Post;
import com.sp.posts.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(String userId);

}