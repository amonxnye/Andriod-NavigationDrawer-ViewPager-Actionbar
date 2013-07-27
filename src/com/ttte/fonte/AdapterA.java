package com.ttte.fonte;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class AdapterA extends PagerAdapter {

    public LayoutInflater mInflater;
    public Context mContext;
    public ViewPager mViewPager;

    public AdapterA(Context c, ViewPager pager) {

        super();
        mContext = c;
        mInflater = LayoutInflater.from(c);
        mViewPager=pager;
        mViewPager.setAdapter(this);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3;            //this truely determines the number of screens shown
    }

    @Override
    public boolean isViewFromObject(View pager, Object obj) {

        return pager == obj;
    }

    @Override
    public Object instantiateItem(View pager, int position) { // this where the viewpager is inflated with our different pages
        View v = null;
        if (position == 0) {
            v = mInflater.inflate(R.layout.amonte1, null);        //for example this page is inflated or placed in from here
          //  Button button1 = (Button) v.findViewById(R.id.button1);
           // button1.setOnClickListener(mPagerClickListener);
        } else if (position == 1) {
            v = mInflater.inflate(R.layout.amonte2, null);    //for example this page is inflated or placed in from here
          //  Button button2 = (Button) v.findViewById(R.id.button2);
           // button2.setOnClickListener(mPagerClickListener);
        } else if (position == 2) {
            v = mInflater.inflate(R.layout.amonte3, null);    //for example this page is inflated or placed in from here
            //  Button button2 = (Button) v.findViewById(R.id.button2);
            // button2.setOnClickListener(mPagerClickListener);
        }
        ((ViewPager) pager).addView(v, 0);

        return v;
    }

   // private View.OnClickListener mPagerClickListener = new View.OnClickListener() {

       // @Override
       // public void onClick(View v) {

         //   switch (v.getId()){
            //    case R.id.button1:
           //         changeviewpager(1);
            //        Toast.makeText(mContext, "Button 1", Toast.LENGTH_SHORT).show();
             //       break;
             //   case R.id.button2:
              //      changeviewpager(2);
              //      Toast.makeText(mContext, "Button 2", Toast.LENGTH_SHORT).show();
              //      break;
          //  }
       // }
    //};

    public void changeviewpager(int type) {

        if(type==1){
            mViewPager.setCurrentItem(1);
        }else if(type==2){
            mViewPager.setCurrentItem(0);
        }
    }

    @Override
    public void destroyItem(View pager, int position, Object view) {
        ((ViewPager) pager).removeView((View) view);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }

    @Override
    public void finishUpdate(View arg0) {
    }
}