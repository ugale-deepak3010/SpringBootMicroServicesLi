package Li4_ExploreCalifornia.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Li4_ExploreCalifornia.Model.Tour;
import Li4_ExploreCalifornia.Model.TourRating;
import Li4_ExploreCalifornia.Repository.TourRatingRepo;
import Li4_ExploreCalifornia.Repository.TourRepo;

@ExtendWith(MockitoExtension.class)
public class TourRatingServiceTest {

	private static final int CUSTOMER_ID = 123;
	private static final int TOUR_ID = 1;
	private static final int TOUR_RATING_ID = 100;

	@Mock
	private TourRepo tourRepoMock;

	@Mock
	private TourRatingRepo tourRatingRepoMock;

	@Mock
	private TourRatingService service;

	@Mock
	private Tour tourMock;

	@Mock
	private TourRating tourRatingMock;

	@Mock
	private TourRating tourRatingMock2;

	@Test
	public void lookUpRatingById() {

		when(tourRatingRepoMock.findById(TOUR_RATING_ID)).thenReturn(Optional.of(tourRatingMock));

		// not working
		// assertThat(service.lookupRatingById(TOUR_RATING_ID).get() ,
		// is(tourRatingMock));

		assertEquals(service.lookupRatingById(TOUR_RATING_ID).get(), is(tourRatingMock));

	}

	@Test
	public void lookupAll() {
		when(tourRatingRepoMock.findAll()).thenReturn(Arrays.asList(tourRatingMock));

		assertEquals(service.lookupAllTourRating().get(0), is(tourRatingMock));
	}
	
	// I am lazy to implement all others!

}
