package com.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Train {
	@Id
	private int id;
	private String name;
	private int train_no;
	private Date date;
	private String t_from,t_to;
	private float rate;
	private int seat;
	public Train() {
		// TODO Auto-generated constructor stub
	}
	
	public Train(String name) {
		super();
		this.name = name;
	}

	public Train(int id, String name, int train_no, Date date, String t_from, String t_to, float rate, int seat) {
		super();
		this.id = id;
		this.name = name;
		this.train_no = train_no;
		this.date = date;
		this.t_from = t_from;
		this.t_to = t_to;
		this.rate = rate;
		this.seat = seat;
	}
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
	public int getTrain_no() {
		return train_no;
	}
	public void setTrain_no(int train_no) {
		this.train_no = train_no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getT_from() {
		return t_from;
	}
	public void setT_from(String t_from) {
		this.t_from = t_from;
	}
	public String getT_to() {
		return t_to;
	}
	public void setT_to(String t_to) {
		this.t_to = t_to;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Train [id=" + id + ", name=" + name + ", train_no=" + train_no + ", date=" + date + ", t_from=" + t_from
				+ ", t_to=" + t_to + ", rate=" + rate + ", seat=" + seat + "]";
	}
}
