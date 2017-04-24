package com.thachnguyenit.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thachnguyenit.R;
import com.thachnguyenit.models.NewsModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsGridViewHolder extends NewsBaseViewHolder {

    @BindView(R.id.iv_news_icon)
    ImageView ivNewsIcon;

    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;

    @BindView(R.id.ll_users_liked)
    LinearLayout llUserLiked;

    public NewsGridViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void loadData(NewsModel news) {
        if (news == null)
            return;
        Glide.with(ivNewsIcon.getContext()).load(news.getIcon()).into(ivNewsIcon);
        tvNewsTitle.setText(news.getTitle());
        addUserLikes(llUserLiked, news.getUserList());
    }

}
