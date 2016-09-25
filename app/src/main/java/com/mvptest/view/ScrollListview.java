package com.mvptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;

import com.mvptest.R;

/**
 * Created by Administrator on 2016/9/23.
 */

public class ScrollListview extends ListView {

    private ImageView imageView;
    private int imageViewHeight = 0;

    public ScrollListview(Context context) {
        super(context);
        imageViewHeight =  context.getResources().getDimensionPixelSize(R.dimen.imageHeight);
    }

    public ScrollListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageViewHeight =  context.getResources().getDimensionPixelSize(R.dimen.imageHeight);
    }

    public ScrollListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        imageViewHeight =  context.getResources().getDimensionPixelSize(R.dimen.imageHeight);
    }

    public void setEnlargeImageView(ImageView imageView){
//        imageViewHeight = imageView.getHeight();
        this.imageView = imageView;
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        Log.i("deltaY","===================="+deltaY);
        Log.i("scrollY","===================="+scrollY);

        if(deltaY<0){
            if (imageView != null) {
                imageView.getLayoutParams().height = imageView.getHeight() - deltaY;
                imageView.requestLayout();
            }
        }else{
            if (imageView.getHeight()>imageViewHeight && imageView != null) {
                imageView.getLayoutParams().height = imageView.getHeight() - deltaY;
                imageView.requestLayout();
            }
        }

        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        View rootView = (View) imageView.getParent();
        Log.i("imageViewHeight","===================="+imageViewHeight);
        //image上滑时缩小
        if(imageView.getHeight()>imageViewHeight && rootView.getTop()<0)
        {
            int top =  rootView.getTop();
            Log.i("rootView.getTop()","===================="+top);
            rootView.layout(rootView.getLeft(),0,rootView.getRight(),rootView.getBottom());
            imageView.getLayoutParams().height = imageView.getHeight() + top;
            imageView.requestLayout();
        }


        super.onScrollChanged(l, t, oldl, oldt);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_UP:
                ResetAnimation animation = new ResetAnimation(imageView,imageViewHeight);
                animation.setDuration(500);
                imageView.startAnimation(animation);
                break;
        }
        return super.onTouchEvent(ev);
    }




    class ResetAnimation extends Animation{
        private final ImageView imageView;
        private final int targetHeight;
        private final int currentHeight;
        private final int extraHeight;

        public ResetAnimation(ImageView imageView, int targetHeight){
            this.imageView = imageView;
            this.targetHeight = targetHeight;
            this.currentHeight = imageView.getHeight();
            this.extraHeight = currentHeight - targetHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            //interpolatedTime(0.0 -----  1.0)执行的百分比
            Log.i("currentHeight","===================="+currentHeight);
            Log.i("targetHeight","===================="+targetHeight);
            Log.i("interpolatedTime","===================="+interpolatedTime);
            if (imageView != null) {
//                imageView.getLayoutParams().height = 现在的高度 -  高度差 * 百分比;
                imageView.getLayoutParams().height = (int) (currentHeight - extraHeight*interpolatedTime);
                imageView.requestLayout();
            }



            super.applyTransformation(interpolatedTime, t);
        }
    }
}
