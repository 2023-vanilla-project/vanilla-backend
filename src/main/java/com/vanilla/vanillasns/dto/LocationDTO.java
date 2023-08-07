package com.vanilla.vanillasns.dto;

public class LocationDTO {
    private long id;
    private String si;
    private String gu;
    private String dong;

    public LocationDTO() {
    }

    public LocationDTO(long id, String si, String gu, String dong) {
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
        return "LocationDTO{" +
                "id=" + id +
                ", si='" + si + '\'' +
                ", gu='" + gu + '\'' +
                ", dong='" + dong + '\'' +
                '}';
    }
}
