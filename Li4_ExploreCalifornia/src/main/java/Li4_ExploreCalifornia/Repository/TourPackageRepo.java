package Li4_ExploreCalifornia.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import Li4_ExploreCalifornia.Model.TourPackage;

@RepositoryRestResource(path = "package", collectionResourceRel = "TourPackage")
@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage, String> {

	Optional<TourPackage> findByName(String name);

}
