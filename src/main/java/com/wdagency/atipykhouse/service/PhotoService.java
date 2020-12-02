package com.wdagency.atipykhouse.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wdagency.atipykhouse.model.Photo;
import com.wdagency.atipykhouse.repository.PhotoRepository;

@Service
public class PhotoService {

	@Autowired
	PhotoRepository photoRepo;

	public List<Photo> findByHebergementId(String id) {
		return photoRepo.findByHebergementId(id);
	}

	@Transactional
	public void saveImageFile(String hebergementId, MultipartFile file) {

		try {

			Photo photo = new Photo();
			photo.setName(file.getName());

			byte[] byteObjects = new byte[file.getBytes().length];

			int i = 0;

			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}

			photo.setFile(byteObjects);

			photoRepo.save(photo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
