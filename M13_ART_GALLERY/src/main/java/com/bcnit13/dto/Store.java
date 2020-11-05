package com.bcnit13.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "adress")
	private String adress;
	@Column(name = "capacity")
	private int capacity;

	@OneToMany(mappedBy = "store", orphanRemoval = true, targetEntity = Picture.class)
	private List<Picture> pictures;

	public Store() {

	}

	public Store(String name, String adress, int capacity) {
		this.name = name;
		this.adress = adress;
		this.capacity = capacity;
	}

	public Store(Long id, String name, String adress, int capacity) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.capacity = capacity;

	}

	public Long getId() {
		return id;
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

	@JsonIgnore
	@JoinColumn(name = "id")
	public List<Picture> getPicture() {
		return pictures;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPicture(List<Picture> picture) {
		this.pictures = picture;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", adress=" + adress + ", capacity=" + capacity + ", picture="
				+ pictures + "]";
	};

}
