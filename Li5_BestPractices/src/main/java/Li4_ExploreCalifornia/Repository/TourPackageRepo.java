package Li4_ExploreCalifornia.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import Li4_ExploreCalifornia.Model.TourPackage;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Tour Package Repo", description = "Tour Package API")
@RepositoryRestResource(path = "package", collectionResourceRel = "TourPackage")
@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage, String> {

	Optional<TourPackage> findByName(String name);

}
