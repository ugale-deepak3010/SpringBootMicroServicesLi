package com.TourImageService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TourImageService.Model.IdName;
import com.TourImageService.Model.Image;

public interface ImageRepo extends MongoRepository<Image, String> {

	Optional<Image> findByFileName(String fileName);
	
	List<IdName> findIdNameBy();

}
