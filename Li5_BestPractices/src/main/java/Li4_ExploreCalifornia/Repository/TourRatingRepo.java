package Li4_ExploreCalifornia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import Li4_ExploreCalifornia.Model.TourRating;

@Repository
@RepositoryRestResource(exported = false)
public interface TourRatingRepo extends JpaRepository<TourRating, Integer> {

	List<TourRating> findByTourId(Integer tourId);

	Optional<TourRating> findByTourIdAndCustomerId(Integer tourId, Integer customerId);
}
