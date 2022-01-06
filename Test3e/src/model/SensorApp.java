package model;

public class SensorApp extends WeatherApp {

	public SensorApp(String name, int max_stations) {
		super(name, max_stations);
	}
	
	public String toString() {
		if (this.nos == 0) {
			return "Weather Sensor App " + this.name + " is connected to no stations.";
		} else {
			String str = "Weather Sensor App " + this.name + " is connected to " + this.nos + " stations: <";
			
			for (int i = 0; i < this.nos; i++) {
				str += this.stations[i].getName();
				
				if (i < this.nos - 1) {
					str += ", ";
				}
			}
			
			str += ">.";
			
			return str;
		}
	}

	public void updateMeasurements(String name, int temp, int air) {
		for (int i = 0; i < this.nos; i++) {
			if (this.stations[i].getName().equals(name)) {
				this.stations[i].setTemp(temp); 
				this.stations[i].setAir(air);
				this.stations[i].setActive(true);
			}
		}
	}

	public String[] getConnectedForcastersOf(String station) {
		String[] str = new String[0];
		for (int i = 0; i < this.nos; i ++) {
			if (this.stations[i].getName().equals(station)) {
				str = new String[this.stations[i].getForecasters().length];
			}
		}
		
		int counter = 0;
		for (int i = 0; i < this.nos; i ++) {
			if (this.stations[i].getName().equals(station)) {
				for (int j = 0; j < this.stations[i].getForecasters().length; j ++) {
					str[counter] = this.stations[i].getForecasters()[j].getName() + " at index " + (counter+1);
					counter++;
				}
			}
		}
		
		return str;
	}

}
