package com.bcnit13.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "picture")
public class Picture{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne(optional = false, fetch = FetchType.EAGER,  targetEntity = Store.class)
	@JoinColumn(name = "store_id")
	private Store store;

	public Picture() {
	}

	public Picture(String title, String author, Store store) {
		this.title = title;
		this.author = author;
		this.date = new Date();
		this.store = store;
	}

	public Picture(Long id, String title, String author, Date date, Store store) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.store = store;
	}
	
	public Picture(Long id, String title, String author, Store store) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = new Date();
		this.store = store;
	}
	

	private Picture(String title, String author, Date date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}
	@JsonIgnore
	public Store getStore() {
		return store;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTittle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Long getStoreId() {
		return this.store.getId();
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", title=" + title + ", author=" + author + ", date=" + date + ", store="
				+ store + "]";
	}

}



