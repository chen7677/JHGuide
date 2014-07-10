package com.block.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.block.act.BlockActivity;
import com.block.fragment.content.PageFragment1;
import com.block.fragment.rightslider.rightSliderFragment;
import com.block.jhguide.R;

public class MainActivity extends BlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState) ;
//		setAbContentView(R.layout.tab_bottom_block_test) ;
//		setAbContentView(R.layout.tab_top_block_test) ;
		setAbContentView(R.layout.sliding_play_block_test);
//		initDefaultTopBar() ;
		
//		setLeftSliderView(new PageFragment2()) ;
		setRightSliderView(new rightSliderFragment()) ;
//		addTab() ;
		addImgs();
	}

	
	private void addImgs() {
		// TODO Auto-generated method stub
		List<View>imageList = new ArrayList<View>();
		ImageView imageView1 = new ImageView(this);
		imageView1.setImageResource(R.drawable.ic_launcher);
		ImageView imageView2 = new ImageView(this);
		imageView2.setImageResource(R.drawable.ic_launcher);
		ImageView imageView3 = new ImageView(this);
		imageView3.setImageResource(R.drawable.ic_launcher);
		ImageView imageView4 = new ImageView(this);
		imageView4.setImageResource(R.drawable.ic_launcher);
		imageList.add(imageView1);
		imageList.add(imageView2);
		imageList.add(imageView3);
//		imageList.add(imageView4);
		
		setSliderShowImage(imageList, R.id.mAbSlidingPlayView);
	}


	private void addTab(){
		PageFragment1 page1 = new PageFragment1();
		PageFragment1 page2 = new PageFragment1();
		PageFragment1 page3 = new PageFragment1();
		PageFragment1 page4 = new PageFragment1();
		PageFragment1 page5 = new PageFragment1();
		
		List<Fragment> mFragments = new ArrayList<Fragment>();
		mFragments.add(page1);
		mFragments.add(page2);
		mFragments.add(page3);
		mFragments.add(page4);
		mFragments.add(page5);
		
		List<String> tabTexts = new ArrayList<String>();
		tabTexts.add(" 玩转生活");
		tabTexts.add("江大地图");
		tabTexts.add("官方信息");
		tabTexts.add("那些年");
		tabTexts.add("更多");
		
		ArrayList<Drawable> tabDrawables = new ArrayList<Drawable>();
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu1_n));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu1_f));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu2_n));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu2_f));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu3_n));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu3_f));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu1_n));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu1_f));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu4_n));
		tabDrawables.add(this.getResources().getDrawable(R.drawable.menu4_f));
		
		setBottomTabs(mFragments, tabTexts, tabDrawables, R.id.mBottomTabView);
//		setTopTabsView(mFragments, tabTexts, R.id.mAbSlidingTabView) ;
	}
}
