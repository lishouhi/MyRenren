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
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.main);
	imgbtn_top_left = (ImageButton) this.findViewById(R.id.imgbtn_top_left);
	imgbtn_top_left.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View v) {
		toggle();// ����SlidingMenu�Ĵ���ر�
	    }
	});
	// ��ʼ�������˵�
	initSlidingMenu(savedInstanceState);
    }

    /**
     * ��ʼ�������˵�
     */
    private void initSlidingMenu(Bundle savedInstanceState) {
	// ���û����˵�����ͼ
	setBehindContentView(R.layout.menu_frame);
	getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, new LeftBottomFragment()).commit();
	// ʵ���������˵�����
	SlidingMenu sm = getSlidingMenu();
	// ���û�����Ӱ�Ŀ��
	sm.setShadowWidthRes(R.dimen.shadow_width);
	// ���û�����Ӱ��ͼ����Դ
	sm.setShadowDrawable(R.drawable.shadow);
	// ���û����˵���ͼ�Ŀ��
	sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
	// ���ý��뽥��Ч����ֵ
	sm.setFadeDegree(0.35f);
	// ���ô�����Ļ��ģʽ
	sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    /**
     * �л���ͼ
     * 
     * @param fragment
     */
    public void switchContent(Fragment fragment) {
	getSupportFragmentManager().beginTransaction()
		.replace(R.id.container, fragment).commit();
	getSlidingMenu().showContent();
    }
}
