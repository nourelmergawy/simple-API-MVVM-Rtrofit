package com.mrg.apitask;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;



public class MyList {
    @SerializedName("albumId")
    private String albumId;
    @SerializedName("title")
    private String title ;
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String ImgUri;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUri() {
        return ImgUri;
    }

    public void setImgUri(String imgUri) {
        ImgUri = imgUri;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public MyList(String albumId, String title, String id, String imgUri, String thumbnailUrl) {
        this.albumId = albumId;
        this.title = title;
        this.id = id;
        ImgUri = imgUri;
        this.thumbnailUrl = thumbnailUrl;
    }
}
