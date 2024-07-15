package Li4_ExploreCalifornia;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Li4_ExploreCalifornia.Model.Difficulty;
import Li4_ExploreCalifornia.Model.Region;
import Li4_ExploreCalifornia.Service.TourFromFile;
import Li4_ExploreCalifornia.Service.TourPackageService;
import Li4_ExploreCalifornia.Service.TourService;

@SpringBootApplication
public class Li4ExploreCaliforniaApplication implements CommandLineRunner {

	
	//http://localhost:8080/swagger-ui/index.html
	private static final String TOUR_IMPORT_FILE = "ExploreCalifornia_FlatFileData.json";

	@Autowired
	TourPackageService tourPackageService;

	@Autowired
	TourService tourService;

	public static void main(String[] args) {
		
		
		
		SpringApplication.run(Li4ExploreCaliforniaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		

		createTourAllPackages();
		System.err.println("Persisted Packages count: " + tourPackageService.total());
		createTourFromFile(TOUR_IMPORT_FILE);

		System.err.println("Persisted Tours count: " + tourService.total());
		
		
	}

	private void createTourAllPackages() {

		tourPackageService.createTourPackage("BC", "BackPack Cal");
		tourPackageService.createTourPackage("CC", "California Camp");
		tourPackageService.createTourPackage("CH", "California Hot Spring");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kid's Cal");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard California");
		tourPackageService.createTourPackage("TC", "Taste of California");
	}

	
		
	private void createTourFromFile(String tourImportFile) throws StreamReadException, DatabindException, IOException {

		
		TourFromFile.read(tourImportFile).forEach(tourFromFile->{
						
			try {
				tourService.createTour(
						tourFromFile.packageName(), 
						tourFromFile.title(),
						tourFromFile.description(),
						tourFromFile.blurb(),
						tourFromFile.price(),
						tourFromFile.length(),
						tourFromFile.bullets(),
						tourFromFile.keywords(),
						Difficulty.valueOf(tourFromFile.difficulty().toUpperCase()),
						Region.findByLabel(tourFromFile.region())					
						);
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
		});
	}

}
