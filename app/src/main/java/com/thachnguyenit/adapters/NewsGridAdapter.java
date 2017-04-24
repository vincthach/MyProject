package com.thachnguyenit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thachnguyenit.R;
import com.thachnguyenit.models.NewsModel;
import com.thachnguyenit.viewholders.NewsGridViewHolder;

import java.util.List;

public class NewsGridAdapter extends RecyclerView.Adapter<NewsGridViewHolder> {

    List<NewsModel> newsList;

    public NewsGridAdapter(List<NewsModel> newsList) {
        this.newsList = newsList;
    }

    @Override
    public NewsGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_grid, parent, false);
        NewsGridViewHolder viewHolder = new NewsGridViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsGridViewHolder holder, int position) {
        NewsModel news = newsList.get(position);
        holder.loadData(news);
    }

    @Override
    public int getItemCount() {
        if (newsList == null || newsList.isEmpty()) {
            return 0;
        }
        return newsList.size();
    }
}
