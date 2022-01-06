package model;

public class Account {
	
	private String account_name;
	private AppStore store;
	private String status;
	
	private App[] downloaded_apps = new App[50];
	private int noad = 0;

	public Account(String account_name, AppStore store) {
		this.account_name = account_name;
		this.store = store;
		this.status = "An account linked to the " + this.store.getBranch() + " store is created for " + this.account_name + ".";
	}
	
	public String toString() {
		return this.status;
		
	}

	public String[] getNamesOfDownloadedApps() {
		String[] names = new String[this.noad];
		
		for (int i = 0; i < this.noad; i++) {
			names[i] = this.downloaded_apps[i].getName();
		}
		return names;
	}

	public App[] getObjectsOfDownloadedApps() {
		App[] objs = new App[this.noad];
		
		for (int i = 0; i < this.noad; i++) {
			objs[i] = this.downloaded_apps[i];
		}
		return objs;
	}

	public void uninstall(String name) {
		App[] updated_downloaded = new App[50];
		App[] downloaded = this.getObjectsOfDownloadedApps();
		boolean found = false;
		
		int counter = 0; 
		for (int i = 0; i < downloaded.length; i++) {
			if (!downloaded[i].getName().equals(name)) {
				updated_downloaded[counter] = downloaded[i];
				counter++;
			} else {
				found = true;
			}
		}
		
		this.downloaded_apps = updated_downloaded;
		this.noad = counter;
		
		if (found) {
			this.status = name + " is successfully uninstalled for " + this.account_name + ".";
		} else {
			this.status = "Error: " + name + " has not been downloaded for " + this.account_name + ".";
		}
	}

	public void submitRating(String name, int rating) {
		App[] downloaded = this.getObjectsOfDownloadedApps();
		boolean found = false;
		
		
		for (int i = 0; i < downloaded.length; i++) {
			if (downloaded[i].getName().equals(name)) {
				downloaded[i].submitRating(rating);
				found = true;
			}
		}
		
		if (found) {
			this.status = "Rating score " + rating + " of " + this.account_name + " is successfully submitted for " + name + ".";
		} else {
			this.status = "Error: " + name + " is not a downloaded app for " + this.account_name + ".";
		}
		
	}

	public void switchStore(AppStore new_store) {
		this.store = new_store;
		this.status = "Account for " + this.account_name + " is now linked to the " + new_store.getBranch() + " store.";
	}

	public void download(String app_name) {
		App[] downloaded = this.getObjectsOfDownloadedApps();
		boolean found = false;
		
		
		for (int i = 0; i < downloaded.length; i++) {
			if (downloaded[i].getName().equals(app_name)) {
				found = true;
			}
		}
		
		if (found) {
			this.status =  "Error: " + app_name + " has already been downloaded for " + this.account_name + ".";
		} else {
			this.downloaded_apps[this.noad] = this.store.getApp(app_name);
			this.noad++;
			this.status =  app_name + " is successfully downloaded for " + this.account_name + ".";
		}
		
	}

}
