package com.TourImageService.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

//like SQL table 
@Builder
@Document(collection = "images")
@Data
public class Image {
	
	@Id
	private String id;
	private String fileName;
	private byte[] data;

}
