package com.thachnguyenit.viewholders;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thachnguyenit.models.UserModel;
import com.thachnguyenit.utils.BackgroundUtil;

import java.util.List;

import com.thachnguyenit.R;

public abstract class NewsBaseViewHolder extends RecyclerView.ViewHolder {

    public NewsBaseViewHolder(View itemView) {
        super(itemView);
    }

    public void addTags(LinearLayout llNewsTag, List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return;
        }
        for (String tag : tags) {
            View tagItem = View.inflate(llNewsTag.getContext(), R.layout.item_news_tag_text, null);
            View tagItemContainer = tagItem.findViewById(R.id.tv_tag_container);
            TextView tvTag = (TextView)tagItem.findViewById(R.id.tv_tag);
            tvTag.setText(tag);
            GradientDrawable gd = BackgroundUtil.createBackgroundRandom();
            tagItemContainer.setBackground(gd);
            llNewsTag.addView(tagItem);
        }
        llNewsTag.invalidate();
    }

    public void addUserLikes(LinearLayout llUserLiked, List<UserModel> userList) {
        if (userList == null || userList.isEmpty()) {
            return;
        }
        int marginLeft = llUserLiked.getResources().getDimensionPixelOffset(R.dimen.margin_user_profile_image);

        for (int i = 0; i < userList.size(); i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            UserModel user = userList.get(i);
            View view = View.inflate(llUserLiked.getContext(), R.layout.item_user_profile_image, null);
            ImageView ivUserProfile = (ImageView) view.findViewById(R.id.iv_user_profile);
            Glide.with(llUserLiked.getContext()).load(user.getAvatar()).into(ivUserProfile);
            layoutParams.setMargins(i == 0 ? 0 : marginLeft, 0, 0 , 0);
            view.setLayoutParams(layoutParams);
            llUserLiked.addView(view);
        }
        llUserLiked.invalidate();
    }

}
