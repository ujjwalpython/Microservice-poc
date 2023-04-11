package com.sp.userpostservice.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private Long postId;
    private String title;
    private String userId;
    private String description;
}
