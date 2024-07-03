package Li4_ExploreCalifornia.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Li4_ExploreCalifornia.Dto.TourRatingDto;
import Li4_ExploreCalifornia.Model.Tour;
import Li4_ExploreCalifornia.Model.TourRating;
import Li4_ExploreCalifornia.Repository.TourRatingRepo;
import Li4_ExploreCalifornia.Repository.TourRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class TourRatingService {

	@Autowired
	TourRatingRepo tourRatingRepo;

	@Autowired
	TourRepo tourRepo;
	
	
	public void rateMany(int tourId, int score, List<Integer> customers) {
		Tour tour= verifyTour(tourId);
		
		for (Integer customerId : customers) {
			if (tourRatingRepo.findByTourIdAndCustomerId(tourId, customerId).isPresent()) {
				throw new ConstraintViolationException("Unable to create duplicate rating!", null);
			}tourRatingRepo.save(new TourRating(tour, customerId, score, null));
		}
	}

	public TourRating createNew(int tourId, int customerId, int score, String comment) {

		return tourRatingRepo.save(new TourRating(verifyTour(tourId), customerId, score, comment));
	}

	public List<TourRating> lookupAllTourRating() {

		return tourRatingRepo.findAll();
	}

	public Double getAvarageScoreOfTour(int tourId) {
		List<TourRating> tours = tourRatingRepo.findByTourId(tourId);

		OptionalDouble average = tours.stream().mapToInt(tourRating -> tourRating.getScore()).average();

		return average.isPresent() ? average.getAsDouble() : null;
	}

	public void deleteTourRating(int tourId, int customerId) {

		TourRating tourRating = verifyTourAndCustomer(tourId, customerId);
		tourRatingRepo.delete(tourRating);
	}

	public List<TourRating> lookupRatingByTour(int tourId) {

		return tourRatingRepo.findByTourId(tourId);
	}

	public Optional<TourRating> lookupRatingById(int id) {

		return tourRatingRepo.findById(id);
	}

	public TourRatingDto update(int tourId, int customerId, int score, String comment) {

		TourRating tourRating = verifyTourAndCustomer(tourId, customerId);
		tourRating.setScore(score);
		tourRating.setComment(comment);

		TourRating savedTourRating = tourRatingRepo.save(tourRating);

		return new TourRatingDto(savedTourRating.getScore(), savedTourRating.getComment(),
				savedTourRating.getCustomerId());
	}

	public TourRatingDto updateSome(int tourId, int customerId, Optional<Integer> score, Optional<String> comment) {

		TourRating tourRating = verifyTourAndCustomer(tourId, customerId);
		score.ifPresent(s -> tourRating.setScore(s));
		comment.ifPresent(c -> tourRating.setComment(c));

		TourRating savedTourRating = tourRatingRepo.save(tourRating);

		return new TourRatingDto(savedTourRating.getScore(), savedTourRating.getComment(),
				savedTourRating.getCustomerId());
	}

	private TourRating verifyTourAndCustomer(int tourId, int customerId) {

		return tourRatingRepo.findByTourIdAndCustomerId(tourId, customerId)
				.orElseThrow(() -> new NoSuchElementException(
						"No Tour/customer found on this tourId: " + tourId + " customerId: " + customerId));
	}

	private Tour verifyTour(int tourId) {

		return tourRepo.findById(tourId).orElseThrow(() -> new NoSuchElementException("TourId not found = " + tourId));
	}

}
