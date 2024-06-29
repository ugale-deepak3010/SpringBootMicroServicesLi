package SpringBootMicroServicesLi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import tour.Repository.TourRepo;
import tour.Service.TourManagementService;
import tour.Service.TourTravelAgentService;

@SpringBootApplication
public class SpringBootMicroServicesLiApplication {

	public static void main(String[] args) {

		TourRepo tourRepo = new TourRepo();
		TourTravelAgentService tourTravelAgentService = new TourTravelAgentService(tourRepo);

		new TourManagementService(tourRepo);

		System.err.println("***\t TOUR CATALOGUE \t***");
		tourTravelAgentService.displayTour();

		System.err.println("\n\n***\t KID FRIENDLY TOUR CATALOGUE \t***");
		tourTravelAgentService.displayToursBy(true);

		// SpringApplication.run(SpringBootMicroServicesLiApplication.class, args);
	}

}
