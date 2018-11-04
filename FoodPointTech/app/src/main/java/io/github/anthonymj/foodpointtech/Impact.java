package io.github.anthonymj.foodpointtech;


public class Impact {
	private Double CO2Emissions;
	private Double landUsage;
	private Double waterUsage;
	private int avgExpiration;
	
	public Impact(Double cO2Emissions, Double landUsage, Double waterUsage, int avgExpiration) {
		super();
		CO2Emissions = cO2Emissions;
		this.landUsage = landUsage;
		this.waterUsage = waterUsage;
		this.avgExpiration = avgExpiration;
	}
	
	

}
