package com.bcnit13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bcnit13.dto.Picture;
import com.bcnit13.dto.Store;
import com.bcnit13.services.PictureServiceImpl;
import com.bcnit13.services.StoreServiceImpl;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	StoreServiceImpl storeServiceImpl;
	@Autowired
	PictureServiceImpl pictureServiceImpl;

	@PostMapping("/shops")
	public ResponseEntity<Store> addStore(@RequestParam String name, String adress, int cap)  throws Exception {
		
			return new ResponseEntity<>(storeServiceImpl.createStore(name, adress, cap), HttpStatus.OK);
		
	}

	@PostMapping("/shops/{ID}/pictures")
	public ResponseEntity<Picture> addPicture(@PathVariable(name = "ID") Long ID, @RequestParam String title,
			String author) throws Exception {
		if (author == null || author == "") {
			author = "anonymous";
		}
		return new ResponseEntity<>(pictureServiceImpl.addPicture(title, author, storeServiceImpl.findStoreById(ID)),
				HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}")
	public ResponseEntity<String> findStoreById(@PathVariable(name = "ID") Long ID){
		try {
			
			return new ResponseEntity<>(storeServiceImpl.findStoreById(ID).toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Store with id: "+ ID + " not found.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/shops")
	public ResponseEntity<List<Store>> findAllStores() throws Exception {
		return new ResponseEntity<>(storeServiceImpl.findAllStore(), HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}/pictures")
	public ResponseEntity<List<Picture>> findAllPictures(@PathVariable(name = "ID") Long ID) throws Exception {
		return new ResponseEntity<>(storeServiceImpl.showPicturesByShopId(ID), HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}/picture")
	public ResponseEntity<String> findPictureById(@PathVariable(name = "ID") Long ID) throws Exception {
		try {
			
		return new ResponseEntity<>(pictureServiceImpl.findPictureById(ID).toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Picture with id: "+ ID + " not found.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/shops/{ID}")
	public ResponseEntity<Store> editStore(@PathVariable(name = "ID") Long ID, @RequestParam String name, String adress,
			int cap) throws Exception {
		return new ResponseEntity<>(storeServiceImpl.updateStore(ID, name, adress, cap), HttpStatus.OK);
	}

	@PutMapping("/shops/{ID}/picture")
	public ResponseEntity<Picture> editPicture(@PathVariable(name = "ID") Long ID, @RequestParam String title,
			String author, Long store_id) throws Exception {
		if (author == null || author == "") {
			author = "anonymous";
		}
		return new ResponseEntity<>(
				pictureServiceImpl.editPicture(ID, title, author, storeServiceImpl.findStoreById(store_id)),
				HttpStatus.OK);
	}

	@DeleteMapping("/shops/{ID}")
	public void deleteStoreById(@PathVariable(name = "ID") Long ID) throws Exception {
		storeServiceImpl.deleteStoreById(ID);
	}

	@DeleteMapping("/shops/{ID}/pictures")
	public void deletePicturesByStoreId(@PathVariable(name = "ID") Long ID) throws Exception {
		storeServiceImpl.showPicturesByShopId(ID).forEach(p -> pictureServiceImpl.deleteById(p.getId()));
	}

	@DeleteMapping("/shops/{ID}/picture")
	public void deletePictureById(@PathVariable(name = "ID") Long ID) throws Exception {
		pictureServiceImpl.deleteById(ID);
	}

}
