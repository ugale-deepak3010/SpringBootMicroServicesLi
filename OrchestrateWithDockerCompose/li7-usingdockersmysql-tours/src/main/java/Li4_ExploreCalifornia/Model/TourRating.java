package Li4_ExploreCalifornia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class TourRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "tour_id")
	private Tour tour;
	
	private int customerId;
	private int score;
	private String comment;
	
	public TourRating(Tour tour, int customerId, int score, String comment) {
		super();
		this.tour = tour;
		this.customerId = customerId;
		this.score = score;
		this.comment = comment;
	}
	
	
	

}
