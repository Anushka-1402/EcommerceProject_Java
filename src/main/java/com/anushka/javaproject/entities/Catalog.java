package com.anushka.javaproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class Catalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogId;
	private String catalogName;
	private String catalogDesc;
	@OneToMany(mappedBy = "pCat")
	private List<Product> products= new ArrayList<>();
	
	
	public Catalog() {
		super();
	}

	public Catalog(int catalogId, String catalogName, String catalogDesc, List<Product> products) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.catalogDesc = catalogDesc;
		this.products = products;
	}

	public Catalog(String catalogName, String catalogDesc) {
		super();
		this.catalogName = catalogName;
		this.catalogDesc = catalogDesc;
	}
	
	public Catalog(String catalogName, String catalogDesc, List<Product> products) {
		super();
		this.catalogName = catalogName;
		this.catalogDesc = catalogDesc;
		this.products = products;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getCatalogDesc() {
		return catalogDesc;
	}

	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Catalog [catalogId=" + catalogId + ", catalogName=" + catalogName + ", catalogDesc=" + catalogDesc
				+ ", products=" + products + "]";
	}

	
	
}
