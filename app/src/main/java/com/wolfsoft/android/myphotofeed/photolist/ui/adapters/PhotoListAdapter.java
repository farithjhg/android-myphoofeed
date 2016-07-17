package com.wolfsoft.android.myphotofeed.photolist.ui.adapters;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wolfsoft.android.myphotofeed.R;
import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.domain.Util;
import com.wolfsoft.android.myphotofeed.entities.Photo;
import com.wolfsoft.android.myphotofeed.lib.base.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by farithjhg on 30/06/2016.
 */
public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private Util utils;
    private List<Photo> photoList;
    private ImageLoader imageLoader;
    private OnItemClickListener onItemClickListener;
    private FirebaseAPI firebase;

    public PhotoListAdapter(FirebaseAPI firebase, Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        this.firebase = firebase;
        this.utils = utils;
        this.photoList = photoList;
        this.imageLoader = imageLoader;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_photos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo currentPhoto = photoList.get(position);
        holder.setOnItemClickListener(currentPhoto, onItemClickListener);

        imageLoader.load(holder.imgMain, currentPhoto.getUrl());
        imageLoader.load(holder.imgAvatar, utils.getAvatarUrl(currentPhoto.getEmail()));
        holder.txtUser.setText(currentPhoto.getEmail());
        double lat = currentPhoto.getLatitutde();
        double lng = currentPhoto.getLongitude();
        holder.btnLike.setTag(currentPhoto.getLike());
        holder.txtCountLike.setText("[" + currentPhoto.getLike() + "]");
        holder.txtCountDislike.setText("["+currentPhoto.getDisLike()+"]");

        if(currentPhoto.likedByMe(firebase.getAuthEmail())){
            holder.btnLike.setImageResource(R.drawable.like_b);
        }else{
            holder.btnLike.setImageResource(R.drawable.like_w);
        }

        if(currentPhoto.disLikedByMe(firebase.getAuthEmail())){
            holder.btnNotLike.setImageResource(R.drawable.dislike_b);
        }else{
            holder.btnNotLike.setImageResource(R.drawable.dislike_w);
        }

        if (lat != 0.0 && lng != 0.0) {
            holder.txtPlace.setText(utils.getFromLocation(lat, lng));
            holder.txtPlace.setVisibility(View.VISIBLE);
        } else {
            holder.txtPlace.setVisibility(View.GONE);
        }

        if (currentPhoto.isPublishedByMe()) {
            holder.btnDelete.setVisibility(View.VISIBLE);
        } else {
            holder.btnDelete.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void addPhoto(Photo photo) {
        photoList.add(0, photo);
        notifyDataSetChanged();
    }

    public void removePhoto(Photo photo) {
        photoList.remove(photo);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imgAvatar)
        CircleImageView imgAvatar;
        @Bind(R.id.txtUser)
        TextView txtUser;
        @Bind(R.id.imgMain)
        ImageView imgMain;
        @Bind(R.id.txtPlace)
        TextView txtPlace;
        @Bind(R.id.imgShare)
        ImageButton btnShare;
        @Bind(R.id.imgLike)
        ImageButton btnLike;
        @Bind(R.id.txtCountLike)
        TextView txtCountLike;
        @Bind(R.id.imgDelete)
        ImageButton btnDelete;
        @Bind(R.id.imgNotLike)
        ImageButton btnNotLike;
        @Bind(R.id.txtCountDislike)
        TextView txtCountDislike;
        boolean isImageFitToScreen;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener(final Photo photo,
                                           final OnItemClickListener listener) {
            txtPlace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPlaceClick(photo);
                }
            });
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onShareClick(photo, imgMain);
                }
            });

            imgMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.showImage(photo);
                }
            });


            btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onLikeClick(photo);
                }
            });

            btnNotLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDisLikeClick(photo);
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteClick(photo);
                }
            });
        }
    }
}