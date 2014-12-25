package com.pps.myrenren.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pps.myrenren.adapter.CommonOrMoreAdapter;
import com.pps.myrenren.adapter.SettingAdapter;
import com.pps.myrenren.model.ItemComOrMoreModel;
import com.pps.myrenren.model.ItemSettingModel;

import android.widget.AdapterView.OnItemClickListener;

public class LeftBottomFragment extends Fragment implements OnItemClickListener {
    private View mView;
    private Context mContext;
    private ListView listview_common;
    private ListView listview_more;
    private ListView listview_setting;

    private List<ItemComOrMoreModel> commonModels; // �����б��Item����
    private List<ItemComOrMoreModel> moreModels; // �����б��item����
    private List<ItemSettingModel> settingModels; // �����б��item����

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	if (null == mView) {
	    mView = inflater.inflate(R.layout.fragment_left_bottom, container,
		    false);
	    initView();
	    initValidata();
	    bindData();
	}
	return mView;
    }

    /**
     * ��ʼ������Ԫ��
     */
    private void initView() {
	listview_common = (ListView) mView.findViewById(R.id.listview_common);
	listview_common.setOnItemClickListener(LeftBottomFragment.this);

	listview_more = (ListView) mView.findViewById(R.id.listview_more);
	listview_setting = (ListView) mView.findViewById(R.id.listview_setting);
    }

    /**
     * ��ʼ������
     */
    private void initValidata() {
	mContext = mView.getContext();
	commonModels = new ArrayList<ItemComOrMoreModel>();
	moreModels = new ArrayList<ItemComOrMoreModel>();
	settingModels = new ArrayList<ItemSettingModel>();
	// 1:���й��쳣���б��е�����,ͼ��,����,����
	Integer[] common_icon_id = new Integer[] {
		R.drawable.v5_2_1_desktop_list_newsfeed,
		R.drawable.v5_2_1_desktop_list_message,
		R.drawable.v5_2_1_desktop_list_chat,
		R.drawable.v5_2_1_desktop_list_friends,
		R.drawable.v5_2_1_desktop_list_search,
		R.drawable.v5_9_3_desktop_list_barcode };
	String[] arrays_commom = mContext.getResources().getStringArray(
		R.array.arrays_commom);
	int[] common_number = new int[] { 0, 1, 2, 3, 4, 1 };
	for (int i = 0; i < common_icon_id.length; i++) {
	    ItemComOrMoreModel commcon = new ItemComOrMoreModel(
		    common_icon_id[i], arrays_commom[i], common_number[i]);
	    commonModels.add(commcon);
	}

	// 2�����й�������б��е�����,ͼ��,����,����
	Integer[] more_icon_id = new Integer[] {
		R.drawable.v5_2_1_desktop_list_location,
		R.drawable.v5_2_1_desktop_list_page,
		R.drawable.v5_2_0_desktop_list_hot,
		R.drawable.v5_2_1_desktop_list_apps_center };
	String[] arrays_more = mContext.getResources().getStringArray(
		R.array.arrays_more);
	int[] more_number = new int[] { 0, 0, 0, 0 };
	for (int i = 0; i < more_icon_id.length; i++) {
	    ItemComOrMoreModel more = new ItemComOrMoreModel(more_icon_id[i],
		    arrays_more[i], more_number[i]);
	    moreModels.add(more);
	}

	// 3:���й��������б��е�����,ͼ��,����
	Integer[] setting_icon_id = new Integer[] {
		R.drawable.v_5_8day_mode_unselected,
		R.drawable.v5_2_1_desktop_list_settings,
		R.drawable.v5_2_1_desktop_list_log_out };
	String[] arrays_setting = mContext.getResources().getStringArray(
		R.array.arrays_setting);
	for (int i = 0; i < setting_icon_id.length; i++) {
	    ItemSettingModel setting = new ItemSettingModel(setting_icon_id[i],
		    arrays_setting[i]);
	    settingModels.add(setting);
	}
    }

    /**
     * ������
     */
    private void bindData() {
	// �������������ҽ��а����ݵ�listview��
	listview_common.setAdapter(new CommonOrMoreAdapter(mContext,
		commonModels));
	listview_more.setAdapter(new CommonOrMoreAdapter(mContext, moreModels));
	listview_setting
		.setAdapter(new SettingAdapter(mContext, settingModels));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
	    long id) {
	// TODO Auto-generated method stub
	Fragment newContent = null;
	switch (position) {
	case 0:
	    newContent = new AboutFragment();
	    break;
	case 1:
	    newContent = new HomeFragment();
	    break;
	}
	
	if (newContent != null) {
	    switchFragment(newContent);
	}
    }

    private void switchFragment(Fragment fragment) {
	if (getActivity() == null) {
	    return;
	}
	if (getActivity() instanceof MainActivity) {
	    MainActivity fca = (MainActivity) getActivity();
	    fca.switchContent(fragment);
	}
    }

}