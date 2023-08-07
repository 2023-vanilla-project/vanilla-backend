package com.vanilla.vanillasns.dto;

public class PostDTO {

    private long id;
    private long categoryId;
    private String userId;
    private String content;
    private String image;
    private long locationId;
    private String date;

    public PostDTO() {
    }

    public PostDTO(long id, long categoryId, String userId, String content, String image, long locationId, String date) {
        this.id = id;
        this.categoryId = categoryId;
        this.userId = userId;
        this.content = content;
        this.image = image;
        this.locationId = locationId;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", locationId=" + locationId +
                ", date='" + date + '\'' +
                '}';
    }
}
