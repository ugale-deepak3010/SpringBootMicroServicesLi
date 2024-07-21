package com.TourImageService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TourImageService.Model.IdName;
import com.TourImageService.Model.Image;
import com.TourImageService.Repository.ImageRepo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class ImageService {
	
	@Autowired
	ImageRepo imageRepo;

	public Image saveImage(Image image) {

		return imageRepo.save(image);
	}

	public Optional<Image> getImage(String id) {

		return imageRepo.findById(id);
	}

	public Optional<Image> findByName(String fileName) {

		return imageRepo.findByFileName(fileName);
	}

	public List<IdName> findIdByNames() {

		return imageRepo.findIdNameBy();
	}

}
