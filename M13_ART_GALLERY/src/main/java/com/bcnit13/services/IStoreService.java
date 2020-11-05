package com.bcnit13.services;

import java.util.List;

import com.bcnit13.dto.Picture;
import com.bcnit13.dto.Store;

public interface IStoreService {

	public Store createStore(String name, String adress, int capacity);

	public List<Store> findAllStore();

	public Store findStoreById(Long id);

	public List<Picture> showPicturesByShopId(Long id);
	
	public Store updateStore(Long id,String name, String adress, int cap);

	public void deleteStoreById(Long id);


}
