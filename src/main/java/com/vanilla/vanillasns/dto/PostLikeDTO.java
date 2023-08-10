package com.vanilla.vanillasns.dto;

public class PostLikeDTO {
    private long id;
    private long postId;
    private String userId;

    public PostLikeDTO() {
    }

    public PostLikeDTO(long id, long postId, String userId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
