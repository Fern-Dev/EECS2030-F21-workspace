package model;

public class Subscriber extends Follower {

	private String[] videos;
	private int nov;

	public Subscriber(String name, int max_channels, int max_videos) {
		super(name, max_channels);
		this.videos = new String[max_videos];
	}
	
	public String toString() {
		String str = "Subscriber " + super.name + " follows ";
		
		if (super.noc > 0) {
			str += "[";
			for (int i = 0; i < super.noc; i++) {
				str += super.channels[i].getName();
				if (i < super.noc - 1) {
					str += ", ";
				}
			}
			str += "] ";
		} else {
			str += "no channels ";
		}
		
		str += "and ";
		
		if (this.nov > 0) {
			str += "is recommended <";
			for (int i = 0; i < this.nov; i++) {
				str += this.videos[i];
				if (i < this.nov - 1) {
					str += ", ";
				}
			}
			str += ">.";
		} else {
			str += "has no recommended videos.";
		}
		
		
		return str;
	}
	
	public void addVideo(String video) {
		this.videos[this.nov] = video;
		this.nov++;
	}

	public void watch(String video, int minutes) {
		for (int i = 0; i < super.noc; i++) {
			for (int j = 0; j < super.channels[i].getVideos().length; j++) {
				
				if (super.channels[i].getVideos()[j].equals(video)) {
					for (int k = 0; k < super.channels[i].getFollowers().length; k++) {
						
						if (super.channels[i].getFollowers()[k] instanceof Monitor) {
							Monitor follower = (Monitor) super.channels[i].getFollowers()[k];
							follower.updateViews(super.channels[i], minutes);
						}
					}
				}
			}
		}
	}
}
