package model;

public class FilterAll extends SeqEvaluator {

	public FilterAll(int i) {
		super.sequences = new SeqOperation[i];
	}
	
	public String toString() {
		String str = "Filter ";
		
		int count = 0;
		
		for (int i = 0; i < super.nos; i ++) {
			if (super.sequences[i].getArray() != null) {
				count++;
			}
		}
		
		if (count == 0) {
			str += "result is: ";
			for (int i = 0; i < super.nos;i ++) {
				if (super.sequences[i].isValid()) {
					str += "true";
				} else {
					str += "_";
				}
				
				if (i < super.nos - 1) {
					str += ", ";
				}
			}
		} else {
			str += "cannot be evaluated due to " + count + " incompatile operations.";
		}
		
		return str;
	}

}
