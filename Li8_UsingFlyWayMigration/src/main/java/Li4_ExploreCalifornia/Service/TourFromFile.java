package Li4_ExploreCalifornia.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record TourFromFile(String packageName, String title, String description, String blurb, int price, String length,
		String bullets, String keywords, String difficulty, String region) {

	public static List<TourFromFile> read(String fileToImport) throws StreamReadException, DatabindException, IOException {

		return new ObjectMapper().readValue(
				new File(fileToImport), 
				new TypeReference<List<TourFromFile>>() {}
				);

	}
}
