package com.bcnit13.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreDto {

	@JsonProperty("name")
	private String name;
	@JsonProperty("adress")
	private String adress;
	@JsonProperty("capacity")
	private int capacity;
	@JsonProperty("pictures")
	private List<Picture> pictures;

	public StoreDto() {
	}

	public static StoreDto fromStoreToDto(Store store) {
		StoreDto dto = new StoreDto();
		dto.setName(store.getName());
		dto.setAdress(store.getAdress());
		dto.setCapacity(store.getCapacity());
		dto.setPictures(store.getPicture());
		return dto;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

}
