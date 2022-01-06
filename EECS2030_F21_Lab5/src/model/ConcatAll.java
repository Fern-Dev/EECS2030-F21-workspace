package model;

public class ConcatAll extends SeqEvaluator {

	public ConcatAll(int i) {
		super.sequences = new SeqOperation[i];
	}
	
	public String toString() {
		String str = "";
		
		int count = 0;
		
		for (int i = 0; i < super.nos; i ++) {
			if (super.sequences[i].getArray() == null) {
				count++;
			}
		}
		
		
		if (count == 0) {
			str = "Concat(";
			
			for (int i = 0; i < this.nos; i ++) {
				int[] arr = super.sequences[i].getArray();
				
				str += "[";
				
				for (int j = 0; j < arr.length; j ++) {
					str += arr[j];
					
					if (j < arr.length - 1) {
						str += ", ";
					}
				}
				
				str += "]";
				
				if (i < super.nos - 1) {
					str += ", ";
				}
			}
			
			str += ") = [";
			
			for (int i = 0; i < super.nos; i ++) {
				int[] arr = super.sequences[i].getArray();
				
				for (int j = 0; j < arr.length; j ++) {
					str += arr[j];
					
					if (j < arr.length - 1) {
						str += ", ";
					}
				}
				
				if (i < super.nos - 1) {
					if (super.sequences[i+1].getArray().length != 0 ) {
						str += ", ";
					}
				}
			}
			
			str += "]";
		} else {
			str += "Concat cannot be evaluated due to " + count + " incompatile operations.";
		}
		
		return str;
	}

}
