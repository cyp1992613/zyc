package com.zyc.entity;

import java.sql.Blob;

public class Zyc_knowledge {

	private int zyc_id;
	private String zyc_name;
	private Blob zyc_knowledge;

	public int getZyc_id() {
		return zyc_id;
	}

	public void setZyc_id(int zyc_id) {
		this.zyc_id = zyc_id;
	}

	public String getZyc_name() {
		return zyc_name;
	}

	public void setZyc_name(String zyc_name) {
		this.zyc_name = zyc_name;
	}

	public Blob getZyc_knowledge() {
		return zyc_knowledge;
	}

	public void setZyc_knowledge(Blob zyc_knowledge) {
		this.zyc_knowledge = zyc_knowledge;
	}

}
