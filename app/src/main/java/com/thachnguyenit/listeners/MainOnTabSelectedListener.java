package com.thachnguyenit.listeners;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.thachnguyenit.R;

public class MainOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.tab_selected_line).setVisibility(View.VISIBLE);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.tab_selected_line).setVisibility(View.GONE);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.tab_selected_line).setVisibility(View.VISIBLE);
    }
}
