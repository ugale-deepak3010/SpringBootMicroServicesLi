package Li4_ExploreCalifornia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Li4_ExploreCalifornia.Model.Difficulty;
import Li4_ExploreCalifornia.Model.Tour;
import Li4_ExploreCalifornia.Model.TourPackage;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
 *
 * 
 *  findBy CAMALCASE ENTITY QUERI.
 *  Optional for single record.
 * 	List for Multiple records.
 * 	
 * 	countBy for long or int
 * see more documentation on spring jpa doc page.
 * 
 * 
 * 
 */

@Tag(name = "Tour Repo", description = "Tour repository for API.")
@Repository
public interface TourRepo extends JpaRepository<Tour, Integer> {

	List<Tour> findByDifficulty(Difficulty difficulty );

	List<Tour> findByTourPackageCode(TourPackage tourPackageCode);

}
