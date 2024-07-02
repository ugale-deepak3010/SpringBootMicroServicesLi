package Li4_ExploreCalifornia.Model;

public enum Region {
	
	Central_Coast("Central Coast"),
	Southern_California("Southern California"),
	Northern_California("Northen California "),
	Varies("Varies");
	
	private String label;
	
	Region(String label) {
		
		this.label= label;
	}

	public static Region findByLabel(String label) {
		
		
		for (Region region : Region.values()) {
			
			if (region.label.equalsIgnoreCase(label)) {
				return region;
			}
		}
		
		return null;
	}

}
