package SpringBootMicroServicesLi.tour.Service;

import org.springframework.stereotype.Service;

import SpringBootMicroServicesLi.tour.Model.Tour;
import SpringBootMicroServicesLi.tour.Repository.TourRepo;


@Service
public class TourManagementService {
	
	
	TourRepo tourRepo;

	 public  TourManagementService(TourRepo tourRepo) {
		this.tourRepo = tourRepo;
		
		
		// dummy record.
		System.err.println("Record Creation Start");
		createTour("Big Sur Retreat", 750, true);
		createTour("Big spa Retreat", 1550, false);
		createTour("Big Montere Retreat", 50, true);
		createTour("Big Kids LA Retreat", 150, true);
		createTour("Big IsLanad Retreat", 350, true);
		createTour("Big Endagerd Retreat", 200, true);
		createTour("Big sur3 Retreat", 900, false);
		createTour("Big Sur4 Retreat", 800, true);
		
		System.err.println("Record Creation End");
			
	}
	
	
	public Tour createTour(String title, Integer price, boolean isKidFriendly) {
		
		return tourRepo.save(new Tour(title, price, isKidFriendly));
	}
	
	

}
