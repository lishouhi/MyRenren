package com.pps.myrenren.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
    private ImageButton imgbtn_top_left;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	//设置无标题
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	//设置布局文件
	setContentView(R.layout.main);
	
	//
	imgbtn_top_left = (ImageButton) this.findViewById(R.id.imgbtn_top_left);
	imgbtn_top_left.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View v) {
		//尽心SlidingMenu的打开与关闭
		toggle();
	    }
	});
	
	// 初始化滑动菜单
	initSlidingMenu(savedInstanceState);
    }

    /**
     * 初始化滑动菜单
     */
    private void initSlidingMenu(Bundle savedInstanceState) {
	// 设置滑动菜单的视图
	setBehindContentView(R.layout.menu_frame);
	getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, new LeftBottomFragment()).commit();
	// 实例化滑动菜单对象
	SlidingMenu sm = getSlidingMenu();
	// 设置滑动阴影的宽度
	sm.setShadowWidthRes(R.dimen.shadow_width);
	// 设置滑动阴影的图像资源
	sm.setShadowDrawable(R.drawable.shadow);
	// 设置滑动菜单视图的宽度
	sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
	// 设置渐入渐出效果的值
	sm.setFadeDegree(0.35f);
	// 设置触摸屏幕的模式
	sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    /**
     * 切换视图
     * 
     * @param fragment
     */
    public void switchContent(Fragment fragment) {
	getSupportFragmentManager().beginTransaction()
		.replace(R.id.container, fragment).commit();
	getSlidingMenu().showContent();
    }
}
