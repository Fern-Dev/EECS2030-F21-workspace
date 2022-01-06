package model;

public class AppStore {
	private String brnach;
	
	private App[] apps;
	private int noa = 0;

	public AppStore(String branch, int max_apps) {
		this.brnach = branch;
		this.apps = new App[max_apps];
	}

	public String getBranch() {
		return this.brnach;
	}

	public App getApp(String app) {
		for (int i = 0; i < this.noa; i++) {
			if (this.apps[i].getName().equals(app)) {
				return this.apps[i];
			}
		}
		return null;
	}

	public String[] getStableApps(int updates) {
		String[] stableApps = new String[0];
		
		for (int i = 0; i < this.noa; i++) {
			if (this.apps[i].getUpdateHistory().length >= updates) {
				stableApps = new String[stableApps.length + 1];
			}
		}
		
		int counter = 0;
		
		for (int i = 0; i < this.noa; i++) {
			if (this.apps[i].getUpdateHistory().length >= updates) {
				String str = this.apps[i].getName() + " (" + this.apps[i].getUpdateHistory().length + " versions; Current Version: ";		
				stableApps[counter] = str + this.apps[i].getWhatIsNew() + ")";
				counter++;
			}
		}
		
		
		return stableApps;
	}

	public void addApp(App app) {
		this.apps[this.noa] = app;
		this.noa++;
	}

}
