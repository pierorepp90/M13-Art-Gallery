package com.bcnit13.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcnit13.dto.Picture;
import com.bcnit13.dto.PictureDto;
import com.bcnit13.dto.Store;
import com.bcnit13.dto.StoreDto;
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
	public ResponseEntity<StoreDto> addStore(@RequestBody Store store) throws Exception {

		return new ResponseEntity<>(StoreDto.fromStoreToDto(storeServiceImpl.newStore(store)), HttpStatus.OK);

	}

	@PostMapping("/shops/{ID}/pictures")
	public ResponseEntity<PictureDto> addPicture(@PathVariable(name = "ID") Long ID, @RequestBody Picture pic)
			throws Exception {
		if (pic.getAuthor() == null || pic.getAuthor() == "") {
			pic.setAuthor("anonymous");
		}
		pic.setStore(storeServiceImpl.findStoreById(ID));
		return new ResponseEntity<>(PictureDto.fromPictureToDto(pictureServiceImpl.newPicture(pic)), HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}")
	public ResponseEntity<StoreDto> findStoreById(@PathVariable(name = "ID") Long ID) throws Exception {
		return new ResponseEntity<>(StoreDto.fromStoreToDto(storeServiceImpl.findStoreById(ID)), HttpStatus.OK);

	}

	@GetMapping("/shops")
	public ResponseEntity<List<StoreDto>> findAllStores() throws Exception {
		return new ResponseEntity<>(storeServiceImpl.findAllStore().stream().map(s -> StoreDto.fromStoreToDto(s))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}/pictures")
	public ResponseEntity<List<PictureDto>> findAllPictures(@PathVariable(name = "ID") Long ID) throws Exception {
		return new ResponseEntity<>(storeServiceImpl.showPicturesByShopId(ID).stream()
				.map(pic -> PictureDto.fromPictureToDto(pic)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping("/shops/{ID}/picture")
	public ResponseEntity<PictureDto> findPictureById(@PathVariable(name = "ID") Long ID) throws Exception {

		return new ResponseEntity<>(PictureDto.fromPictureToDto(pictureServiceImpl.findPictureById(ID)), HttpStatus.OK);
	}

	@PutMapping("/shops/{ID}")
	public ResponseEntity<StoreDto> editStore(@PathVariable(name = "ID") Long ID, @RequestParam String name,
			String adress, int cap) throws Exception {
		return new ResponseEntity<>(StoreDto.fromStoreToDto(storeServiceImpl.updateStore(ID, name, adress, cap)),
				HttpStatus.OK);
	}

	@PutMapping("/shops/{ID}/picture")
	public ResponseEntity<PictureDto> editPicture(@PathVariable(name = "ID") Long ID, @RequestParam String title,
			String author, Long store_id) throws Exception {
		if (author == null || author == "") {
			author = "anonymous";
		}
		return new ResponseEntity<>(
				PictureDto.fromPictureToDto(
						pictureServiceImpl.editPicture(ID, title, author, storeServiceImpl.findStoreById(store_id))),
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
