package model;

public class Blueprint {
	
	private Floor[] floors;
	private int nof;

	public Blueprint(int floors) {
		this.floors = new Floor[floors];
	}
	
	public Blueprint(Blueprint bp) {
		this.floors = new Floor[bp.floors.length];
		Floor[] new_floors = bp.getFloors();
		
		for (int i = 0; i < new_floors.length; i ++) {
			this.floors[i] = new_floors[i];
			this.nof++;
		}
	}

	public String toString() {
		return  String.format("%.1f", ((double) this.nof / this.floors.length) * 100) + " percents of building blueprint completed (" + this.nof + " out of " + this.floors.length + " floors)";
	}

	public void addFloorPlan(Floor floor) {
		this.floors[this.nof] = floor;
		this.nof++;
	}

	public Floor[] getFloors() {
		Floor[] floors = new Floor[this.nof];
		
		for (int i = 0; i < this.nof; i ++) {
			floors[i] = new Floor(this.floors[i]);
		}
		
		return floors;
	}

}
