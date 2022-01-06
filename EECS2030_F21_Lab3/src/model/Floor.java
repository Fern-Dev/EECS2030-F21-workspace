package model;

public class Floor {
	
	private int square_feet;
	private int square_feet_used;
	
	private Unit[] units = new Unit[20];
	private int nou;
	
	public Floor(int square_feet) {
		this.square_feet = square_feet;
	}
	
	public Floor(Floor floor) {
		this.square_feet = new Integer(floor.square_feet);
		this.square_feet_used = new Integer(floor.square_feet_used);
		this.units = new Unit[20];
		for (int i = 0; i < floor.nou; i ++) {
			this.units[i] = new Unit(floor.units[i].getFunction(), floor.units[i].getDiminsions()[0], floor.units[i].getDiminsions()[1]);
			this.nou++;
		}
	}
	
	public String toString() {
		String str = "Floor's utilized space is " + this.square_feet_used + " sq ft (" + (this.square_feet - this.square_feet_used) + " sq ft remaining): [";
		
		for (int i = 0; i < this.nou; i ++) {
			str += this.units[i].getFunction() + ": " + this.units[i].getDiminsions()[0] * this.units[i].getDiminsions()[1] + " sq ft (" + this.units[i].getDiminsions()[0] + "' by " + this.units[i].getDiminsions()[1] + "')";
			if (i != this.nou - 1) {
				str += ", ";
			}
		}
		str += "]";
		return str;
	}

	public void addUnit(String function, int width, int length) throws InsufficientFloorSpaceException {
		int sqft = width * length;
		
		if (this.square_feet_used + sqft <= this.square_feet) {
			this.units[this.nou] = new Unit(function, width, length);
			this.square_feet_used += sqft;
			this.nou++;
		} else {
			throw new InsufficientFloorSpaceException();
		}
	}
	
	public boolean equals(Object f2) {
		if (f2 == null) return false;
		if (this.getClass() != f2.getClass()) return false;
		
		Floor f = (Floor) f2;
		if (this.square_feet == f.square_feet && this.nou == f.nou) {
			boolean match = true;
			for (int i = 0; i < this.nou && match; i ++) {
				for (int i2 = 0; i2 < f.nou; i2 ++) {
					if (this.units[i].equals(f.units[i2])) {
						break;
					} else if (i2 == f.nou - 1) {
						match = false;
					}
				}
			}
			return match;
		} else {
			return false;
		}
	}

}
