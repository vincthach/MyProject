package com.thachnguyenit.components;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpaceDecorator extends RecyclerView.ItemDecoration {

    private final int columnCount;

    private final int spaceInPixels;

    enum Position {TOP_LEFT, TOP_CENTER, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, BOTTOM_CENTER, LEFT, CENTER, RIGHT};

    public GridSpaceDecorator(int columnCount, int spaceInPixels) {
        this.columnCount = columnCount;
        this.spaceInPixels = spaceInPixels;
    }

    public GridSpaceDecorator(int columnCount, int spaceInPixels, float densityMultiplier) {
        this.columnCount = columnCount;
        this.spaceInPixels = (int) (spaceInPixels * densityMultiplier);
    }

    public void leftPos(Rect outRect, Position position) {
        if (position.equals(Position.TOP_LEFT)) {
            outRect.left = 0;
            outRect.right = spaceInPixels/2;
            outRect.top = 0;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.LEFT)) {
            outRect.left = 0;
            outRect.right = spaceInPixels/2;
            outRect.top = spaceInPixels/2;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.BOTTOM_LEFT)) {
            outRect.left = 0;
            outRect.right = spaceInPixels/2;
            outRect.top = spaceInPixels/2;
            outRect.bottom = 0;
        }
    }

    public void rightPos(Rect outRect, Position position) {
        if (position.equals(Position.TOP_RIGHT)) {
            outRect.left = spaceInPixels/2;
            outRect.right = 0;
            outRect.top = 0;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.RIGHT)) {
            outRect.left = spaceInPixels/2;
            outRect.right = 0;
            outRect.top = spaceInPixels/2;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.BOTTOM_RIGHT)) {
            outRect.left = spaceInPixels/2;
            outRect.right = 0;
            outRect.top = spaceInPixels/2;
            outRect.bottom = 0;

        }
    }

    public void centerPos(Rect outRect, Position position) {
        if (position.equals(Position.TOP_CENTER)) {
            outRect.left = spaceInPixels/2;
            outRect.right = spaceInPixels/2;
            outRect.top = 0;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.CENTER)) {
            outRect.left = spaceInPixels/2;
            outRect.right = spaceInPixels/2;
            outRect.top = spaceInPixels/2;
            outRect.bottom = spaceInPixels/2;
            return;
        }
        if (position.equals(Position.BOTTOM_CENTER)) {
            outRect.left = spaceInPixels/2;
            outRect.right = spaceInPixels/2;
            outRect.top = spaceInPixels/2;
            outRect.bottom = 0;
        }
    }



    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int total = parent.getAdapter().getItemCount();
        if (position < columnCount) {
            if (position == 0) {
                leftPos(outRect, Position.TOP_LEFT);
                return;
            }
            if (position == columnCount - 1) {
                rightPos(outRect, Position.TOP_RIGHT);
                return;
            }
            centerPos(outRect, Position.TOP_CENTER);
            return;
        }

        if (position >= total - columnCount) {
            if (position == total - 1) {
                rightPos(outRect, Position.BOTTOM_RIGHT);
                return;
            }
            if (position == total - columnCount) {
                leftPos(outRect, Position.BOTTOM_LEFT);
                return;
            }
            centerPos(outRect, Position.BOTTOM_CENTER);
            return;
        }
        if (position % columnCount == 0) {
            leftPos(outRect, Position.LEFT);
            return;
        }
        if ((position + 1) % columnCount == 0) {
            rightPos(outRect, Position.RIGHT);
            return;
        }
        centerPos(outRect, Position.CENTER);
    }
}