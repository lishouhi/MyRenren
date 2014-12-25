package com.pps.myrenren.model;

/**
 * ������ʾ��item��ʵ����
 * 
 * @author jiangqingqing
 * 
 */
public class ItemComOrMoreModel {
	private Integer id; // ��Ҫ������ʾitem��icon��id
	private String name; // item������
	private int num; // δ����Ϣ������

	public ItemComOrMoreModel() {
		super();
	}

	public ItemComOrMoreModel(Integer id, String name, int num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ItemModel [id=" + id + ", name=" + name + ", num=" + num + "]";
	}

}
