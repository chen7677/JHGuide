package com.block.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.ab.activity.AbActivity;
import com.ab.view.titlebar.AbTitleBar;
import com.block.act.BlockActivity;
import com.block.jhguide.R;

public class WelcomeActivity extends AbActivity{

	private ImageView mShowPicture;

	/**
	 * 三个切换的动画
	 */
	private Animation mFadeIn;
	private Animation mFadeInScale;
	private Animation mFadeOut;

	private Drawable mPicture_1;

	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setAbContentView(R.layout.welcome_block);
		
		AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText("");
        mAbTitleBar.setLogo(R.drawable.button_select_menu_block);
        mAbTitleBar.setTitleBarBackground(R.drawable.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.drawable.line);
        
        mAbTitleBar.setVisibility(View.GONE);
		
		mShowPicture = (ImageView) findViewById(R.id.guide_picture);
		init();
		setListener();
	}

	/**
	 * 监听事件
	 */
	private void setListener() {
		/**
		 * 动画切换原理:开始时是用第一个渐现动画,当第一个动画结束时开始第二个放大动画,当第二个动画结束时调用第三个渐隐动画,
		 * 第三个动画结束时修改显示的内容并且重新调用第一个动画,从而达到循环效果
		 */
		mFadeIn.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				mShowPicture.startAnimation(mFadeInScale);
			}
		});
		mFadeInScale.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				mShowPicture.startAnimation(mFadeOut);
			}
		});
		mFadeOut.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

				
			}

			public void onAnimationEnd(Animation animation) {
				toMainView() ;
			}
		});
		
	}
	
	private void toMainView(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	/**
	 * 初始化
	 */
	private void init() {
		initAnim();
		initPicture();
		/**
		 * 界面刚开始显示的内容
		 */
		mShowPicture.setImageDrawable(mPicture_1);
		mShowPicture.startAnimation(mFadeIn);
	}

	/**
	 * 初始化动画
	 */
	private void initAnim() {
		mFadeIn = AnimationUtils.loadAnimation(WelcomeActivity.this,R.anim.welcome_fade_in);
		mFadeIn.setDuration(1000);
		mFadeInScale = AnimationUtils.loadAnimation(WelcomeActivity.this,R.anim.welcome_fade_in_scale);
		mFadeInScale.setDuration(6000);
		mFadeOut = AnimationUtils.loadAnimation(WelcomeActivity.this,R.anim.welcome_fade_out);
		mFadeOut.setDuration(1000);
	}

	/**
	 * 初始化图片
	 */
	private void initPicture() {
		mPicture_1 = getResources().getDrawable(R.drawable.img_welcome);
	}
}
