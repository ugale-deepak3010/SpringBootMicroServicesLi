package Li4_ExploreCalifornia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Li4_ExploreCalifornia.Model.Difficulty;
import Li4_ExploreCalifornia.Model.Region;
import Li4_ExploreCalifornia.Model.Tour;
import Li4_ExploreCalifornia.Model.TourPackage;
import Li4_ExploreCalifornia.Repository.TourPackageRepo;
import Li4_ExploreCalifornia.Repository.TourRepo;

@Service
public class TourService {

	@Autowired
	TourPackageRepo tourPackageRepo;

	@Autowired
	TourRepo tourRepo;

	public TourService(TourPackageRepo tourPackageRepo, TourRepo tourRepo) {

		this.tourPackageRepo = tourPackageRepo;
		this.tourRepo = tourRepo;
	}

	public Tour createTour(String packageName, String title, String description, String blurb, int price, String length,
			String bullets, String keywords, Difficulty difficulty, Region region, TourPackage tourPackage ) {

		return tourRepo
				.save(new Tour((int) (total() + 1), title, description, blurb, price, length, keywords, region, difficulty, null));

	}

	public long total() {
		return tourRepo.count();
	}
	
	
	public List<Tour> lookuByDifficulty(Difficulty difficulty) {
	 return	tourRepo.findByDifficulty(difficulty);
	}
	
	public List<Tour> lookupByPackageCode(TourPackage tourPackageCode) {
		
		return tourRepo.findByTourPackageCode(tourPackageCode);
	}

}
