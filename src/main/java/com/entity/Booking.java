package com.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int b_id;
	private String invoiceno;
	private String name;
	private int trainno;
	private String t_name;
	private String date;
	private int adult,child,totalmember;
	private float totalamount;
	private int u_id; 
	private Date t_date;
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public Booking(int invc,String name, int trainno, String t_name, int adult, int child,int u_id,Date t_date) {
		super();
		//Random random=new Random();
		//for(int i=0;i<4;i++)
		//{
			//this.invoiceno="INVC00"+random.nextInt(9);
		//}
		this.invoiceno="INVC00"+invc;
		this.name = name;
		this.trainno = trainno;
		this.t_name = t_name;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now=LocalDateTime.now();
		this.date = dtf.format(now);
		this.adult = adult;
		this.child = child;
		this.u_id=u_id;
		this.t_date=t_date;
	}
	@Override
	public String toString() {
		return "Booking [b_id=" + b_id + ", invoiceno=" + invoiceno + ", name=" + name + ", trainno=" + trainno
				+ ", t_name=" + t_name + ", date=" + date + ", adult=" + adult + ", child=" + child + ", totalmember="
				+ totalmember + ", totalamount=" + totalamount + "]";
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTrainno() {
		return trainno;
	}
	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getTotalmember() {
		return totalmember;
	}
	public void setTotalmember(int totalmember) {
		this.totalmember = totalmember;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
}
