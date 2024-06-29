package tour.Service;

import tour.Repository.TourRepo;

public class TourTravelAgentService {

	TourRepo tourRepo;

	public TourTravelAgentService(TourRepo tourRepo) {
		this.tourRepo = tourRepo;
	}

	public void displayTour() {

		tourRepo.findAll().stream().forEach(tour -> System.out.println(tour));

	}

	public void displayToursBy(boolean isKidFriendly) {
		
		tourRepo.findByType(isKidFriendly).stream().forEach(tour->System.out.println(tour));
	}
}
