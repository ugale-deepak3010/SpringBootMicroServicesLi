package Li4_ExploreCalifornia.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Li4_ExploreCalifornia.Dto.TourRatingDto;
import Li4_ExploreCalifornia.Model.TourRating;
import Li4_ExploreCalifornia.Service.TourRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Slf4j
@RequestMapping(path = "/tours/{tourId}/ratings")
@Tag(name = "Tour Rating", description = "This controller use for tour rating.")
public class TourRatingController {

	@Autowired
	private TourRatingService tourRatingService;

	@PostMapping("/batch")
	@Operation(summary = "This mathod is use for post multiple customers for rating the tour!")
	public String postBatchTourRating(@PathVariable int tourId, @PathParam("score") int score,
			@RequestBody List<Integer> customers) {

		tourRatingService.rateMany(tourId, score, customers);

		return "Added Successfully..!";
	}

	@GetMapping("/tours")
	@Operation(summary = "Get all Tours rating")
	public List<TourRatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {

		log.error("get in Test Error");

		List<TourRating> tourRatings = tourRatingService.lookupRatingByTour(tourId);
		System.err.println("Pass");

		List<TourRatingDto> tourRatingDtos = new ArrayList<TourRatingDto>();

		System.err.println("TourRating =" + tourRatings.toString() );
		for (TourRating tourRating : tourRatings) {
			tourRatingDtos
					.add(new TourRatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getCustomerId()));
		}

		return tourRatingDtos;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "Create new tour rating")
	public String createTourRating(@PathVariable(value = "tourId") int tourId,
			@RequestBody @Valid TourRatingDto tourRatingDto) {

		log.info("POST /tours/" + tourId + "/ratings");
		log.info("Provided Rating Object: "+tourRatingDto.toString());

		tourRatingService.createNew(tourId, tourRatingDto.getCustomerId(), tourRatingDto.getScore(),
				tourRatingDto.getComment());

		return "Tour Rating added successfully..!";
	}

	@ExceptionHandler(NoSuchElementException.class)
	@Operation(summary = "Handle exceptions!")
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String return404(NoSuchElementException noSuchElementException) {

		System.err.println("I THINK ERROR CAUSED?");
		return noSuchElementException.getMessage();
	}

	@Operation(summary = "Get avg rating!")
	@GetMapping("/average")
	public Double getAverageRating(@PathVariable int tourId) {

		return tourRatingService.getAvarageScoreOfTour(tourId);
	}

	@PutMapping
	@Operation(summary = "update existing tour rating!")
	public TourRatingDto updateTourRating(@PathVariable int tourId, @RequestBody @Valid TourRatingDto tourRatingDto) {

		return tourRatingService.update(tourId, tourRatingDto.getCustomerId(), tourRatingDto.getScore(),
				tourRatingDto.getComment());
	}

	@PatchMapping
	@Operation(summary = "Update spicific tour rating")
	public TourRatingDto patchTourRating(@PathVariable int tourId, @RequestBody @Valid TourRatingDto tourRatingDto) {

		return tourRatingService.updateSome(tourId, tourRatingDto.getCustomerId(),
				Optional.of(tourRatingDto.getScore()), Optional.of(tourRatingDto.getComment()));
	}

	@DeleteMapping("/{customerId}")
	@Operation(summary = "Delete existing ratings!")
	public String deleteTourRating(@PathVariable int tourId, @PathVariable int customerId,
			@RequestBody TourRatingDto tourRatingDto) {

		tourRatingService.deleteTourRating(tourId, customerId);

		return null;
	}

}
