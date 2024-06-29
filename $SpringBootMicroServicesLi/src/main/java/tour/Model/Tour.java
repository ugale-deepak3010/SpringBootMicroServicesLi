package tour.Model;

public record Tour(String title, Integer price, Boolean kidFriendly) {

	@Override
	public String toString() {
		return String.format("%s/t $%d /t Kid Friendly: %s ", title(), price(), kidFriendly ? "Yes" : "No");
	}

}
