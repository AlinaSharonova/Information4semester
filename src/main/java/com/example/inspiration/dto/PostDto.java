package com.example.inspiration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String photoPath;
    private String youTubeLink;
    private String postType;
}
