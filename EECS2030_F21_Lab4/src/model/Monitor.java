package model;

public class Monitor extends Follower {
	
	private double[][] views_stats;

	public Monitor(String name, int maximum_channels) {
		super(name, maximum_channels);
		
		this.views_stats = new double[maximum_channels][3];
	}
	
	public String toString() {
		String str = "Monitor " + super.name + " follows ";
		
		if (super.noc > 0) {
			str += "[";
			for (int i = 0; i < super.noc; i++) {
				str += super.channels[i].getName();
				double[] stats = this.views_stats[i];
				if (stats[0] > 0) {
					str += " {#views: " + String.format("%.0f", stats[0]) + ", max watch time: " + String.format("%.0f", stats[1]) + ", avg watch time: " + String.format("%.2f", stats[2]) + "}";
				}
				if (i < super.noc - 1) {
					str += ", ";
				}
			}
			str += "].";
		} else {
			str += "no channels.";
		}
		
		return str;
	}
	
	public void updateViews(Channel channel, int mins) {
		for (int i = 0; i < super.noc; i++) {
			if (super.channels[i].equals(channel)) {
				this.views_stats[i][0]++;
				
				if (mins > this.views_stats[i][1]) {
					this.views_stats[i][1] = mins;
				}
				
				this.views_stats[i][2] = ((this.views_stats[i][2]*(this.views_stats[i][0] - 1)) + mins)/(this.views_stats[i][0]);
			}
		}
	}
	
	public void removeStats(int index) {
		double[][] views_stats = new double[this.views_stats.length][3];
		
		int counter = 0;
		for (int i = 0; i < this.views_stats.length; i++) {
			if (index != i) {
				views_stats[counter] = this.views_stats[i];
				counter ++;
			}
		}
		
		this.views_stats = views_stats;
	}

}
