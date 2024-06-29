package tour.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tour.Repository.TourRepo;
import tour.Service.TourManagementService;
import tour.Service.TourTravelAgentService;

@Configuration
public class TourBeans {

	@Bean
	public TourRepo tourRepo() {

		System.err.println("1");
		return new TourRepo();
	}

	@Bean
	public TourManagementService tourManagementService() {
		System.err.println("2");
		return new TourManagementService(this.tourRepo());
	}

	@Bean
	public TourTravelAgentService tourTravelAgentService() {
		System.err.println("3");
		return new TourTravelAgentService(this.tourRepo());
	}
}
