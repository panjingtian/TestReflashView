package com.pjt.testreflashview;

import android.content.Context;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2016/05/20.
 */
public class ReFlashListView extends ListView implements AbsListView.OnScrollListener {

    private View header;
    private int headerHeight;
    private int firstItem;    //当前显示的第一个item
    private int scrollstate; //listView当前滚动状态
    private boolean isRemark; //是否是在顶端
    private int startY;
    private int state;




    public ReFlashListView(Context context) {
        super(context);


    }
    public ReFlashListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReFlashListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }


    public  void initView(Context context){
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        header=layoutInflater.inflate(R.layout.header_view,null);
        measureView(header);
        headerHeight=header.getMeasuredHeight();
        toppadding(-headerHeight);

        this.addHeaderView(header);

    }


    public void measureView(View view){
        ViewGroup.LayoutParams p=view.getLayoutParams();
        if(p==null){
            p=new  ViewGroup.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int width=ViewGroup.getChildMeasureSpec(0,0,p.width);
        int height;
        int tempheight=p.height;
        if(tempheight>0){
            height=MeasureSpec.makeMeasureSpec(tempheight,MeasureSpec.EXACTLY);
        }else{
            height=MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED);
        }
        header.measure(width, height);

    }

    public void toppadding(int toppading){
        header.setPadding(header.getPaddingLeft(),toppading,header.getPaddingRight(),
                header.getPaddingBottom());
        header.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
               startY= (int) ev.getY();

                break;


            case MotionEvent.ACTION_UP:

               toppadding(-headerHeight);
                break;



            case MotionEvent.ACTION_MOVE:
                int space= (int) (ev.getY()-startY);
                toppadding(space-headerHeight);


                break;



        }



        return super.onTouchEvent(ev);
    }
}
