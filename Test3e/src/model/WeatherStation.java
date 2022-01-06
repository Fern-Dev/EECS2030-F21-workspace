package model;

public class WeatherStation {
	
	private String name;
	
	private WeatherApp[] apps;
	private int noa;
	
	private boolean active = false;
	
	private int temp;
	private int air;

	public WeatherStation(String name, int max_apps) {
		this.name = name;
		this.apps = new WeatherApp[max_apps];
	}
	
	public String toString() {
		if (this.noa == 0) {
			return this.name + " has no connected apps.";
		} else {
			String str = this.name + " is connected by " + this.noa + " apps: <";
			
			for (int i = 0; i < this.noa; i ++) {
				if (this.apps[i] instanceof SensorApp) {
					str += "Weather Sensor App " + this.apps[i].getName();
				} else {
					str += "Weather Forecast App " + this.apps[i].getName();
				}
				
				if (i < this.noa - 1) {
					str += ", ";
				}
			}
			
			str += ">.";
			return str;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	public int getTemp() {
		return this.temp;
	}
	
	public void setAir(int air) {
		this.air = air;
	}
	
	public int getAir() {
		return this.air;
	}

	public SensorApp[] getSensors() {
		SensorApp[] sensors = new SensorApp[0];
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i] instanceof SensorApp) {
				sensors = new SensorApp[sensors.length + 1];
			}
		}
		
		int counter = 0;
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i] instanceof SensorApp) {
				sensors[counter] = (SensorApp) this.apps[i];
				counter++;
			}
		}
		return sensors;
	}
	
	public ForecastApp[] getForecasters() {
		ForecastApp[] sensors = new ForecastApp[0];
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i] instanceof ForecastApp) {
				sensors = new ForecastApp[sensors.length + 1];
			}
		}
		
		int counter = 0;
		for (int i = 0; i < this.noa; i ++) {
			if (this.apps[i] instanceof ForecastApp) {
				sensors[counter] = (ForecastApp) this.apps[i];
				counter++;
			}
		}
		return sensors;
	}

	public void connect(WeatherApp app) {
		this.apps[this.noa] = app;
		this.noa++;
		app.connect(this);
	}

}
