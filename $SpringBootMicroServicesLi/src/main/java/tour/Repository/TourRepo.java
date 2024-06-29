package tour.Repository;

import java.util.ArrayList;
import java.util.List;

import tour.Model.Tour;

public class TourRepo {

	List<Tour> tours = new ArrayList<>();

	public TourRepo() {

	}

	public Tour save(Tour tour) {

		if (!tours.contains(tour)) {
			tours.add(tour);
		}

		return tour;
	}

	public List<Tour> findAll() {

		return tours;
	}

	public List<Tour> findByType(boolean isKidFriendly) {

		return tours.stream().filter(tour -> tour.kidFriendly() == true).toList();
	}

}
