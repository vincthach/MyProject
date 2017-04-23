package example.com.myproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.myproject.adapters.NewsGridAdapter;
import example.com.myproject.adapters.NewsListAdapter;
import example.com.myproject.components.GridSpaceDecorator;
import example.com.myproject.components.VerticalSpaceDecorator;
import example.com.myproject.configs.NewsConsant;
import example.com.myproject.data.NewsService;
import example.com.myproject.listeners.MainFabButtonClickListener;
import example.com.myproject.listeners.MainOnTabSelectedListener;
import example.com.myproject.models.NewsModel;
import example.com.myproject.utils.AnimationUtil;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.fab_home_container)
    View fabHomeContainer;

    @BindView(R.id.tl_news)
    TabLayout tlNews;

    private NewsListAdapter newsListAdapter;

    private NewsGridAdapter newsGridAdapter;

    private List<NewsModel> newsList;

    private VerticalSpaceDecorator verticalSpacing;

    private GridSpaceDecorator gridSpacing;

    private List<SubActionButton> subActionButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        initTabViews();
        initFabButtons();
        loadListView(true);
    }

    private void initViews() {
        newsList = NewsService.createDummyData();
        newsGridAdapter = new NewsGridAdapter(newsList);
        newsListAdapter = new NewsListAdapter(newsList);
    }

    private void initTabViews() {
        String[] tabs = getResources().getStringArray(R.array.tab_title_news_array);
        for (String tab : tabs) {
            View tabContent = View.inflate(getApplicationContext(), R.layout.item_tab_content, null);
            TextView tvTitle = (TextView) tabContent.findViewById(R.id.tv_tab_title);
            tvTitle.setText(tab);
            tlNews.addTab(tlNews.newTab().setCustomView(tabContent));
        }
        tlNews.addOnTabSelectedListener(new MainOnTabSelectedListener());
        TabLayout.Tab tab = tlNews.getTabAt(0);
        tab.select();

    }

    private void initFabButtons() {
        subActionButtonList = new ArrayList<>();
        TextView fabCollapse = (TextView) View.inflate(getApplicationContext(), R.layout.item_fab, null);
        fabCollapse.setText(R.string.ic_list_collapse);
        TextView fabExpand = (TextView) View.inflate(getApplicationContext(), R.layout.item_fab, null);
        fabExpand.setText(R.string.ic_list_expand);
        TextView fabGrid = (TextView) View.inflate(getApplicationContext(), R.layout.item_fab, null);
        fabGrid.setText(R.string.ic_list_grid);

        int width = getResources().getDimensionPixelSize(R.dimen.width_circle_button);

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this)
                .setTheme(SubActionButton.THEME_LIGHT);

        final SubActionButton sbCollapse = rLSubBuilder.setContentView(fabCollapse)
                .setLayoutParams(new FloatingActionButton.LayoutParams(width, width)).build();
        final SubActionButton sbGrid = rLSubBuilder.setContentView(fabGrid)
                .setLayoutParams(new FloatingActionButton.LayoutParams(width, width)).build();
        final SubActionButton sbExpand = rLSubBuilder.setContentView(fabExpand)
                .setLayoutParams(new FloatingActionButton.LayoutParams(width, width)).build();

        FloatingActionMenu darkButton = new FloatingActionMenu.Builder(this)
                .setStartAngle(180)
                .setEndAngle(270)
                .addSubActionView(sbCollapse)
                .addSubActionView(sbExpand)
                .addSubActionView(sbGrid)
                .attachTo(fabHomeContainer)
                .build();

        sbCollapse.setOnClickListener(new MainFabButtonClickListener(sbCollapse, sbExpand, sbGrid) {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                loadListView(false);
            }
        });

        sbExpand.setOnClickListener(new MainFabButtonClickListener(sbExpand, sbCollapse, sbGrid) {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                loadListView(true);
            }
        });
        sbGrid.setOnClickListener(new MainFabButtonClickListener(sbGrid, sbCollapse, sbExpand) {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                loadGridView();
            }
        });

        sbCollapse.setBackgroundColor(Color.TRANSPARENT);
        sbExpand.setBackgroundColor(Color.TRANSPARENT);
        sbGrid.setBackgroundColor(Color.TRANSPARENT);

        subActionButtonList.add(sbCollapse);
        subActionButtonList.add(sbExpand);
        subActionButtonList.add(sbGrid);

        AnimationUtil.scaleAll(sbCollapse, MainFabButtonClickListener.MAX_SCALE);
    }

    public void loadGridView() {
        if (verticalSpacing != null) {
            rvNews.removeItemDecoration(verticalSpacing);
            verticalSpacing = null;
        }
        int heightDivider = getResources().getDimensionPixelOffset(R.dimen.height_news_list_divider);
        if (gridSpacing == null) {
            gridSpacing = new GridSpaceDecorator(NewsConsant.NEWS_GRID_COLUMNS, heightDivider);
            rvNews.addItemDecoration(gridSpacing);
        }

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), NewsConsant.NEWS_GRID_COLUMNS);
        rvNews.setLayoutManager(gridLayoutManager);
        rvNews.setAdapter(newsGridAdapter);
        rvNews.setItemAnimator(new SlideInDownAnimator());
    }

    public void loadListView(boolean isExpanded) {
        if (gridSpacing != null) {
            rvNews.removeItemDecoration(gridSpacing);
            gridSpacing = null;
        }
        int heightDivider = getResources().getDimensionPixelOffset(R.dimen.height_news_list_divider);
        if (verticalSpacing == null) {
            verticalSpacing = new VerticalSpaceDecorator(heightDivider);
            rvNews.addItemDecoration(verticalSpacing);
        }

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setItemAnimator(new DefaultItemAnimator());
        newsListAdapter.setExpanded(isExpanded);
        rvNews.setAdapter(newsListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearAllListener();
    }

    private void clearAllListener() {
        if (subActionButtonList != null && !subActionButtonList.isEmpty()) {
            for (SubActionButton button : subActionButtonList) {
                button.setOnClickListener(null);
            }
        }
    }
}
