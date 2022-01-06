package model;

public class Follower {
	protected String name;
	
	protected Channel[] channels;
	protected int noc;
	
	public Follower(String name, int max_channels) {
		this.name = name;
		this.channels = new Channel[max_channels];
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addChannel(Channel channel) {
		this.channels[this.noc] = channel;
		this.noc++;
	}
	
	public void removeChannel(Channel channel) {
		Channel[] channels = new Channel[this.channels.length];
		
		boolean found = false;
		int counter = 0;
		for (int i = 0; i < this.noc; i++) {
			if (!this.channels[i].equals(channel)) {
				channels[counter] = this.channels[i];
				counter++;
			} else {
				if (this instanceof Monitor) {
					Monitor follower = (Monitor)this;
					follower.removeStats(i);
				}
				found = true;
			}
		}
		
		if (found) {
			this.noc--;
			this.channels = channels;
		}
	}
}
