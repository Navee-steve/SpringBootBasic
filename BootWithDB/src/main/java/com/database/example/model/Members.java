package com.database.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Members {

	@Id
	private int id;
	private String name;
	private String device;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	@Override
	public String toString() {
		return "MemberDetails [id=" + id + ", name=" + name + ", device=" + device + "]";
	}

}
