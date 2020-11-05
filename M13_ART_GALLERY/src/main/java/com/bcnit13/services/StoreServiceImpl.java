package com.bcnit13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnit13.dao.IStoreDao;
import com.bcnit13.dto.Picture;
import com.bcnit13.dto.Store;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	IStoreDao iStoreDao;

	@Override
	public Store createStore(String name, String adress, int capacity) {
		return iStoreDao.save(new Store(name, adress, capacity));
	}

	@Override
	public List<Store> findAllStore() {
		return iStoreDao.findAll();
	}

	@Override
	public Store findStoreById(Long id) {
		return iStoreDao.findById(id).get();
	}

	@Override
	public List<Picture> showPicturesByShopId(Long id) {
		return iStoreDao.findById(id).get().getPicture();
	}
	
	@Override
	public Store updateStore(Long id, String name, String adress, int cap) {
		Store storeToUpdate = iStoreDao.findById(id).get();
		storeToUpdate.setName(name);
		storeToUpdate.setAdress(adress);
		storeToUpdate.setCapacity(cap);
		return iStoreDao.save(storeToUpdate);
	}

	@Override
	public void deleteStoreById(Long id) {
		iStoreDao.deleteById(id);

	}



}
