package com.bcnit13.services;

import org.springframework.stereotype.Service;

import com.bcnit13.dao.IPictureDao;
import com.bcnit13.dto.Picture;
import com.bcnit13.dto.Store;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PictureServiceImpl implements IPictureService {
	@Autowired
	IPictureDao iPictureDao;

	@Override
	public Picture addPicture(String title, String author, Store store_id) {
		return iPictureDao.save(new Picture(title, author, store_id));
	}
	
	@Override
	public Picture newPicture(Picture pic) {
		return iPictureDao.save(pic);
	}

	@Override
	public Picture findPictureById(Long id) {
		return iPictureDao.findById(id).get();
	}
	
	@Override
	public Picture editPicture(Long id, String title, String author, Store store_id) {
		Picture picToEdit = iPictureDao.findById(id).get();
		picToEdit.setAuthor(author);
		picToEdit.setTittle(title);
		picToEdit.setStore(store_id);
		return iPictureDao.save(picToEdit);
	}

	@Override
	public void deleteById(Long id) {
		iPictureDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		iPictureDao.deleteAll();
	}





}
