package com.example.inspiration.model;

import com.example.inspiration.model.type.PostType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private User author;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private PostType postType;


    private LocalDateTime writeDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    Set<User> likers = new HashSet<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                '}';
    }
}
