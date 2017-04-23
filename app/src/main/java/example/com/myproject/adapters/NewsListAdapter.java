package example.com.myproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.com.myproject.R;
import example.com.myproject.models.NewsModel;
import example.com.myproject.viewholders.NewsListViewHolder;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListViewHolder> {

    List<NewsModel> newsList;

    public NewsListAdapter(List<NewsModel> newsList) {
        this.newsList = newsList;
    }

    private boolean isExpanded = true;

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    @Override
    public NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        NewsListViewHolder viewHolder = new NewsListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, int position) {
        NewsModel news = newsList.get(position);
        holder.loadData(news, isExpanded);
    }

    @Override
    public int getItemCount() {
        if (newsList == null || newsList.isEmpty()) {
            return 0;
        }
        return newsList.size();
    }
}
