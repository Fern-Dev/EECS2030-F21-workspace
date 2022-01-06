package model;

public class WeatherApp {
	
	protected String name;
	
	protected WeatherStation[] stations;
	protected int nos;
	
	public WeatherApp(String name, int max_stations) {
		this.name = name;
		this.stations = new WeatherStation[max_stations];
	}
	
	public String getName() {
		return this.name;
	}
	
	public void connect(WeatherStation station) {
		this.stations[this.nos] = station;
		this.nos++;
	}

}
