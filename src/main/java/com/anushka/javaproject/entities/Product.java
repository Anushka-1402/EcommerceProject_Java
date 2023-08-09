package com.anushka.javaproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String pName;
	private String pDesc;
	private String pPhoto;
	private int pPrice;
	private int pDisc;
	private int pQuantity;
	@ManyToOne
	private Catalog pCat;
	
	public Product() {
		super();
	}

	public Product(int pId, String pName, String pDesc, String pPhoto, int pPrice, int pDisc, int pQuantity,
			Catalog pCat) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDisc = pDisc;
		this.pQuantity = pQuantity;
		this.pCat = pCat;
	}

	public Product(String pName, String pDesc, String pPhoto, int pPrice, int pDisc, int pQuantity, Catalog pCat) {
		super();
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDisc = pDisc;
		this.pQuantity = pQuantity;
		this.pCat = pCat;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpPhoto() {
		return pPhoto;
	}

	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDisc() {
		return pDisc;
	}

	public void setpDisc(int pDisc) {
		this.pDisc = pDisc;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public Catalog getpCat() {
		return pCat;
	}

	public void setCatalog(Catalog pCat) {
		this.pCat = pCat;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice="
				+ pPrice + ", pDisc=" + pDisc + ", pQuantity=" + pQuantity + ", catalog=" + pCat + "]";
	}
	
	public double getDiscountedPrice() {
		
		int disc= this.pDisc;
		int price= this.pPrice;
		
		double ans = (double)price - ((disc*price)/100.0);
		
		return ans;
		
	}
}
