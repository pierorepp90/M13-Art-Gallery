package com.bcnit13.services;

import com.bcnit13.dto.Picture;
import com.bcnit13.dto.Store;

public interface IPictureService {

	public Picture addPicture(String title, String author, Store store_id);
	
	public Picture newPicture(Picture pic);

	public Picture findPictureById(Long id);
	
	public Picture editPicture(Long id,String title, String author, Store store_id);

	public void deleteById(Long id);
	
	public void deleteAll();

}
