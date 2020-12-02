package com.wdagency.atipykhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wdagency.atipykhouse.model.Photo;
import com.wdagency.atipykhouse.service.PhotoService;

@CrossOrigin
@RestController
@RequestMapping("photo")
public class PhotoController {

	
	@Autowired PhotoService photoService;
	
	@GetMapping("/{id}")
	public List<Photo> findByHebergementId(String id) {
		return photoService.findByHebergementId(id);
	}
	
	@PostMapping("/{id}/image")
	public String handleImagePost(@PathVariable String id, @RequestParam MultipartFile file){

		photoService.saveImageFile(id, file);

	    return "redirect:/photo/" + id + "/show";
	}
}
