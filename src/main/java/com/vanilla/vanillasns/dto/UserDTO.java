package com.vanilla.vanillasns.dto;

import java.util.Date;

public class UserDTO {

    private String id;
    private String password;
    private String name;
    private Date birthday;
    private String profileImage;

    public UserDTO() {
    }

    public UserDTO(String id, String password, String name, Date birthday, String profileImage) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.profileImage = profileImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
