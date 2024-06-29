package SpringBootMicroServicesLi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import SpringBootMicroServicesLi.tour.Service.TourTravelAgentService;

@SpringBootApplication
public class SpringBootMicroServicesLiApplication {

	public static void main(String[] args) {

		// beans creation is done by multithreading so result can be vary.

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringBootMicroServicesLiApplication.class);

		TourTravelAgentService tourTravelAgentService = applicationContext.getBean(TourTravelAgentService.class);

		// TourRepo tourRepo = new TourRepo();
		// TourTravelAgentService tourTravelAgentService = new
		// TourTravelAgentService(tourRepo);

		// new TourManagementService(tourRepo);

		System.err.println("***\t TOUR CATALOGUE \t***");
		tourTravelAgentService.displayTour();

		System.err.println("\n\n***\t KID FRIENDLY TOUR CATALOGUE \t***");
		tourTravelAgentService.displayToursBy(true);

		// SpringApplication.run(SpringBootMicroServicesLiApplication.class, args);
	}

}
