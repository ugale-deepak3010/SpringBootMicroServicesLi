package Li4_ExploreCalifornia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Li4_ExploreCalifornia.Model.TourPackage;
import Li4_ExploreCalifornia.Repository.TourPackageRepo;

@Service
public class TourPackageService {

	@Autowired
	TourPackageRepo tourPackageRepo;

	public TourPackageService(TourPackageRepo tourPackageRepo) {
		this.tourPackageRepo = tourPackageRepo;
	}

	public TourPackage createTourPackage(String code, String name) {

		return tourPackageRepo.save(new TourPackage(code, name));
	}

	public List<TourPackage> lookupAll() {

		return tourPackageRepo.findAll();
	}

	public long total() {
		return tourPackageRepo.count();
	}
}
