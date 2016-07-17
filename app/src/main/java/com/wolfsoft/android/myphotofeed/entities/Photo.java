package com.wolfsoft.android.myphotofeed.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farithjhg on 28/06/2016.
 */
public class Photo {
    @JsonIgnore
    private String id;
    @JsonIgnore
    private boolean publishedByMe;
    private int like;
    private int disLike;
    private String url;
    private String email;
    private double latitutde;
    private double longitude;
    private List<String> likeList = new ArrayList<String>();
    private List<String> disLikeList = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPublishedByMe() {
        return publishedByMe;
    }

    public void setPublishedByMe(boolean publishedByMe) {
        this.publishedByMe = publishedByMe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLatitutde() {
        return latitutde;
    }

    public void setLatitutde(double latitutde) {
        this.latitutde = latitutde;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<String> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<String> likeList) {
        this.likeList = likeList;
    }

    public boolean likedByMe(String myEmail){
        boolean exist = false;
        if(likeList!=null && !likeList.isEmpty()){
            for (String _email:likeList) {
                if(_email.equals(myEmail)){
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    public boolean disLikedByMe(String myEmail){
        boolean exist = false;
        if(disLikeList!=null && !disLikeList.isEmpty()){
            for (String _email:disLikeList) {
                if(_email.equals(myEmail)){
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    public int getDisLike() {
        return disLike;
    }

    public void setDisLike(int disLike) {
        this.disLike = disLike;
    }

    public List<String> getDisLikeList() {
        return disLikeList;
    }

    public void setDisLikeList(List<String> disLikeList) {
        this.disLikeList = disLikeList;
    }
}
