package Li4_ExploreCalifornia.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TourRatingDto {

	@Min(0)
	@Max(5)
	private Integer score;

	@Size(max = 255)
	private String comment;

	@NotNull
	private Integer customerId;

}
