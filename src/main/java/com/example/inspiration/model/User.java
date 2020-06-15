package com.example.inspiration.model;

import com.example.inspiration.model.type.Role;
import com.example.inspiration.model.type.State;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    @Column(unique = true)
    private String email;

    private String hashedPassword;

    @ManyToMany(mappedBy = "likers")
    private Set<Post> liked = new HashSet<>();

    private String avatarPath;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
