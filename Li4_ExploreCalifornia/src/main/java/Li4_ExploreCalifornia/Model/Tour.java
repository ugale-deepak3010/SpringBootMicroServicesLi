package Li4_ExploreCalifornia.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String title;

	@Column(length = 2000)
	private String description;

	@Column(length = 2000)
	private String blurb;

	private int price;
	private String duration;
	private String keywords;
	private Region region;

	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	@ManyToOne
	@JoinColumn(name = "tour_package_code")
	private TourPackage tourPackageCode;

}
