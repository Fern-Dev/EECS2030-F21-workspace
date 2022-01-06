package model;

public class ForecastApp extends WeatherApp {
	
	private int max_temp = 0;
	private double avg_temp = 0;
	private int avg_counter = 0;
	int air = 0;
	boolean rain = false;
	
	

	public ForecastApp(String name, int max_stations) {
		super(name, max_stations);
	}
	
	public String toString() {
		if (this.nos == 0) {
			return "Weather Forecast App " + this.name + " is connected to no stations.";
		} else {
			String str = "Weather Forecast App " + this.name + " is connected to " + this.nos + " stations: <";
			
			boolean rain = false;
			
			boolean display = false;
			
			for (int i = 0; i < this.nos; i++) {
				str += this.stations[i].getName();
				
				if (i < this.nos - 1) {
					str += ", ";
				}
				
				if (this.stations[i].getActive()) {
					display = true;
					if ( this.stations[i].getTemp() > this.max_temp) {
						this.max_temp = this.stations[i].getTemp();
					}
					
					if (this.avg_counter == 0) {
						this.avg_temp = this.stations[i].getTemp();
						this.avg_counter++;
					} else {
						this.avg_temp = ((this.avg_temp*this.avg_counter) + this.stations[i].getTemp())/(this.avg_counter+1);
						this.avg_counter++;
					}
					
					
					if (this.air < this.stations[i].getAir()) {
						this.rain = false;
					} else {
						this.rain = true;
					}
					
					this.air = this.stations[i].getAir();
					
					
				
				}
			}
			
			if (display) {
			
				str += " {max temperature: " + max_temp + ", avg temperature: " + String.format("%.1f", avg_temp) + ", ";
				if (this.rain) {
					str += "likely to rain}";
				} else {
					str += "unlikely to rain}";
				}
			}
			str += ">.";
			return str;
		}
	}

}
