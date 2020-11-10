package com.bcnit13.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PictureDto {

	@JsonProperty("title")
	private String title;
	@JsonProperty("author")
	private String author;
	@JsonProperty("date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@JsonProperty("store")
	private Store store;
	
	public PictureDto() {}

	
	public static PictureDto fromPictureToDto(Picture pic) {
		PictureDto dto = new PictureDto();
		dto.setTitle(pic.getTitle());
		dto.setAuthor(pic.getAuthor());
		dto.setDate(pic.getDate());
		dto.setStore(pic.getStore());
		return dto;
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

	public Store getStore() {
		return store;
	}

	public void setTitle(String title) {
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
	
	
		
}
