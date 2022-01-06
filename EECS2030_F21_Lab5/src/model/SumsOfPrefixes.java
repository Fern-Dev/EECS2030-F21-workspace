package model;

public class SumsOfPrefixes extends SeqOperation {
	
	private int[] seq;

	public SumsOfPrefixes(int[] seq) {
		this.seq = seq;
	}
	
	public int[] getArray() {
		int[] sums = new int[1+seq.length];
		int nos = 1;
		sums[0] = 0;
		
		int sum = 0;
		
		for (int i = 0; i < this.seq.length; i++) {
			sum += this.seq[i];
			sums[nos] = sum;
			nos++;
		}	
		
		return sums;
	}
	
	public boolean isValid() {
		return false;
	}

	public String toString() {
		String str = "Sums of prefixes of [";
		for (int i = 0; i < this.seq.length; i++) {
			str += this.seq[i];
			if (i < this.seq.length - 1) {
				str += ", ";
			}
		}
		str += "] is: [";
		if (seq.length > 0) {
			str += "0, ";
		} else {
			str += "0";
		}
		
		int sum = 0;
		
		for (int i = 0; i < this.seq.length; i++) {
			sum += this.seq[i];
			str += sum;
			if (i < this.seq.length - 1) {
				str += ", ";
			}
		}	
		return str + "]";
		
	}
}
