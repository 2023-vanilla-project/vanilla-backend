package com.vanilla.vanillasns.entity;

import javax.persistence.*;

//엔티티 생성
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PostCategory postCategory;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private String image;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private String date;

    public Post() {
    }

    public Post(long id, PostCategory postCategory, User user, String content, String image, Location location, String date) {
        this.id = id;
        this.postCategory = postCategory;
        this.user = user;
        this.content = content;
        this.image = image;
        this.location = location;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postCategory=" + postCategory +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", location=" + location +
                ", date='" + date + '\'' +
                '}';
    }
}
