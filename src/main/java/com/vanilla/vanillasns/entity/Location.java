package com.vanilla.vanillasns.entity;

import javax.persistence.*;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String si;
    private String gu;
    private String dong;

    public Location() {
    }

    public Location(long id, String si, String gu, String dong) {
        this.id = id;
        this.si = si;
        this.gu = gu;
        this.dong = dong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", si='" + si + '\'' +
                ", gu='" + gu + '\'' +
                ", dong='" + dong + '\'' +
                '}';
    }
}
