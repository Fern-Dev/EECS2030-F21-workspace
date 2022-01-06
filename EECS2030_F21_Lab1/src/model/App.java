package model;

public class App {
	private String app_name;
	
	private Log[] updates = new Log[20];
	private int nou = 0;
	
	private int[] ratings;
	private int nor = 0;
	

	public App(String app_name, int max_ratings) {
		this.app_name = app_name;
		this.ratings = new int[max_ratings];
	}

	public String getName() {
		return this.app_name;
	}

	public String getWhatIsNew() {
		if (this.nou > 0) {
			return this.updates[nou - 1].toString();
		}
		return "n/a";
	}

	public Log[] getUpdateHistory() {
		Log[] history = new Log[nou];
		for (int i = 0; i < this.nou; i++) {
			history[i] = updates[i];
		}
		return history;
	}

	public Log getVersionInfo(String version) {
		for (int i = 0; i < this.nou; i++) {
			if (updates[i].getVersion().equals(version)) {
				return updates[i];
			}
		}
		return null;
	}
	
	private double getAvg() {
		double avg = 0.0;
		double sum = 0;
		for (int i = 0; i < this.nor; i++) {
			sum += this.ratings[i];
		}
		avg = sum / this.nor;
		
		return avg;
	}

	public String getRatingReport() {
		if (this.nor > 0) {
			String avg = String.format("%.1f", this.getAvg());
			String str = "Average of " + nor + " ratings: " + avg + " (";
			for (int count = 5; count > 0; count--) {
				int tally = 0;
				for (int i = 0; i < this.nor; i++) {
					if (ratings[i] == count) {
						tally ++;
					}
				}
				if (count == 1) {
					str += "Score " + count + ": " + tally;
				} else {
					str += "Score " + count + ": " + tally + ", ";
				}
			}
			str += ")";
			return str;
		} else {
			return "No ratings submitted so far!";
		}
		
	}
	
	public String toString() {
		if ((this.nou == 0) && (this.nor == 0)) {
			return this.app_name + " (Current Version: n/a; Average Rating: n/a)";
		} else if(this.nou == 0) {
			String avg = String.format("%.1f", this.getAvg());
			return this.app_name + " (Current Version: n/a; Average Rating: " + avg + ")";
		} else if(this.nor == 0) {
			return this.app_name + " (Current Version: " + this.getWhatIsNew() + "; Average Rating: n/a)";
		} else {
			String avg = String.format("%.1f", this.getAvg());
			return this.app_name + " (Current Version: " + this.getWhatIsNew() + "; Average Rating: " + avg + ")";
		}
	}

	public void releaseUpdate(String version) {
		this.updates[this.nou] = new Log(version);
		this.nou++;
		
	}

	public void submitRating(int rating) {
		this.ratings[this.nor] = rating;
		this.nor++;
		
	}

	
	

}
