package com.vanilla.vanillasns.entity;

import javax.persistence.*;

@Entity
@Table(name="post_like")
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PostLike() {
    }

    public PostLike(long id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostLike{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
