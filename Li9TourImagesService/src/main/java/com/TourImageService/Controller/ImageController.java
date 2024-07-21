package com.TourImageService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.TourImageService.Model.IdName;
import com.TourImageService.Model.Image;
import com.TourImageService.Service.ImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Slf4j
@Tag(description = "Upload and get Images List.", name = "Hosting the images")
@RequestMapping("/api/images")
public class ImageController {

	@Autowired
	ImageService imageService;

	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(description = "This method perform file uploading. Upload a file for Tour broucher")
	public Image handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		log.info("Received POST file : " + file.getOriginalFilename());

		return imageService
				.saveImage(Image.builder().fileName(file.getOriginalFilename()).data(file.getBytes()).build());
	}

	@GetMapping("/{id}")
	public byte[] getImage(@PathVariable String Id) {

		return imageService.getImage(Id).get().getData();
	}

	@GetMapping
	public List<IdName> listOfImages() {
		return imageService.findIdByNames();
	}

}
