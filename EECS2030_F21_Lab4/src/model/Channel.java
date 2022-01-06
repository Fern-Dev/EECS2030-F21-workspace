package model;

public class Channel {
	
	private String name;
	
	private Follower[] followers;
	private int nof;
	
	private String[] videos;
	private int nov;
	

	public Channel(String name, int max_followers, int max_videos) {
		this.name = name;
		this.followers = new Follower[max_followers];
		this.videos = new String[max_videos];
	}
	
	public String toString() {
		String str = this.name + " released ";
		
		if (this.nov > 0) {
			str += "<";
			for (int i = 0; i < this.nov; i++) {
				str += this.videos[i];
				if (i < this.nov - 1) {
					str += ", ";
				}
			}
			str += "> ";
		} else {
			str += "no videos ";
		}
		
		str += "and ";
		
		if (this.nof > 0) {
			str += "is followed by [";
			for (int i = 0; i < this.nof; i++) {
				if (this.followers[i] instanceof Subscriber) {
					str += "Subscriber " + this.followers[i].getName();
				} else {
					str += "Monitor " + this.followers[i].getName();
				}
				if (i < this.nof - 1) {
					str += ", ";
				}
			}
			str += "].";
		} else {
			str += "has no followers.";
		}
		
		
		return str;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String[] getVideos() {
		String[] videos = new String[this.nov];
		
		for (int i = 0; i < this.nov; i++) {
			videos[i] = this.videos[i];
		}
		return videos;
	}

	public void releaseANewVideo(String video) {
		this.videos[this.nov] = video;
		this.nov++;
		
		for (int i = 0; i < this.nof; i++) {
			if (this.followers[i] instanceof Subscriber) {
				
				Subscriber follower = (Subscriber) this.followers[i];
				follower.addVideo(video);
			}
		}
	}

	public void follow(Follower follower) {
		this.followers[this.nof] = follower;
		this.nof++;
		
		follower.addChannel(this);
	}

	public void unfollow(Follower follower) {
		Follower[] followers = new Follower[this.followers.length];
		
		boolean found = false;
		int counter = 0;
		for (int i = 0; i < this.nof; i++) {
			if (!this.followers[i].equals(follower)) {
				followers[counter] = this.followers[i];
				counter++;
			} else {
				found = true;
			}
		}
		
		if (found) {
			this.nof--;
			this.followers = followers;
			follower.removeChannel(this);
		}
	}
	
	
	public Follower[] getFollowers() {
		Follower[] followers = new Follower[this.nof];
		
		for (int i = 0; i < this.nof; i++) {
			followers[i] = this.followers[i];
		}
		return followers;
	}

}
