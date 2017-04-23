package example.com.myproject.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.myproject.R;
import example.com.myproject.configs.NewsConsant;
import example.com.myproject.models.NewsModel;
import example.com.myproject.utils.AnimationUtil;
import example.com.myproject.utils.DateUtil;

public class NewsListViewHolder extends NewsBaseViewHolder {

    @BindView(R.id.ll_news_container)
    LinearLayout llNewsContainer;

    @BindView(R.id.ll_news_header)
    LinearLayout llNewsHeader;

    @BindView(R.id.ll_news_header_small)
    LinearLayout llNewsHeaderSmall;

    @BindView(R.id.ll_news_footer)
    LinearLayout llNewsFooter;

    @BindView(R.id.tv_created_date)
    TextView tvCreatedDate;

    @BindView(R.id.tv_created_date_small)
    TextView tvCreatedDateSmall;

    @BindView(R.id.iv_news_icon)
    ImageView ivNewsIcon;

    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;

    @BindView(R.id.ll_users_liked)
    LinearLayout llUserLiked;

    @BindView(R.id.ll_news_tag)
    LinearLayout llNewsTag;

    public NewsListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void loadData(NewsModel news, boolean isExpanded) {
        if (news == null)
            return;
        Glide.with(ivNewsIcon.getContext()).load(news.getIcon()).into(ivNewsIcon);
        tvNewsTitle.setText(news.getTitle());
        addTags(llNewsTag, news.getTagList());
        addUserLikes(llUserLiked, news.getUserList());
        if (isExpanded) {
            llNewsHeaderSmall.setVisibility(View.GONE);
            AnimationUtil.expand(llNewsHeader, NewsConsant.NEWS_GRID_ANIMATION_DURATION);
            AnimationUtil.expand(llNewsFooter, NewsConsant.NEWS_GRID_ANIMATION_DURATION);
        } else {
            AnimationUtil.expand(llNewsHeaderSmall, NewsConsant.NEWS_GRID_ANIMATION_DURATION);
            llNewsHeader.setVisibility(View.GONE);
            llNewsFooter.setVisibility(View.GONE);
        }
        String createdDateText = DateUtil.formatDate(news.getCreatedDate(), NewsConsant.NEWS_CREATED_DATE_PATTERN);
        if (createdDateText != null) {
            tvCreatedDate.setText(createdDateText);
            tvCreatedDateSmall.setText(createdDateText);
        }

    }

}
