package com.pps.myrenren.model;

/**
 * �����б���item��ʵ����
 * 
 * @author jiangqingqing
 * 
 */
public class ItemSettingModel {

	private Integer id; // ����itemͼ���id
	private String name; // ����item������

	public ItemSettingModel() {
		super();
	}

	public ItemSettingModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ItemSettingModel [id=" + id + ", name=" + name + "]";
	}

}
