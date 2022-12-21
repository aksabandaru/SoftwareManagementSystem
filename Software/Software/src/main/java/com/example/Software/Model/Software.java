package com.example.Software.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//to create table
@Table(name="software_table")
public class Software {
	@Column
	private String softwarename;
	@Id//unique
	@GeneratedValue(strategy=GenerationType.IDENTITY)//to give id number by default straing from 1
	@Column
	private int id;
	@Column//to create cloumns in tabels
	private String companyname;
	@Column(nullable=false)
	private String description;
	@Column
	private int stock;
	@Column
	private int price;

	
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
