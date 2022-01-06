package model;

public class OccursWithin extends BinarySeqOperation {
	
	private int[] seq1;
	private int[] seq2;

	public OccursWithin(int[] seq1, int[] seq2) {
		this.seq1 = seq1;
		this.seq2 = seq2;
	}
	
	public int[] getArray() {
		return null;
	}
	
	public boolean isValid() {
		boolean valid = false;
		int length = -1;
		for (int i = 0; i < seq2.length; i ++) {
			if (seq1.length == 0) {
				valid = true;
				break;
			}
			if (seq2[i] == seq1[length + 1]) { //Out of bounds if seq1 = 0 ?
				if (length + 2 == seq1.length) {
					valid = true;
					break;
				}
				length++;
			} else {
				length = -1;
			}
		}
		
		return valid;
	}
	
	public String toString() {
		String str = "[";
		for (int i = 0; i < this.seq1.length; i++) {
			str += this.seq1[i];
			if (i < this.seq1.length - 1) {
				str += ", ";
			}
		}
		str += "] ";
		
		boolean valid = false;
		int length = -1;
		for (int i = 0; i < seq2.length; i ++) {
			if (seq1.length == 0) {
				valid = true;
				break;
			}
			if (seq2[i] == seq1[length + 1]) { //Out of bounds if seq1 = 0 ?
				if (length + 2 == seq1.length) {
					valid = true;
					break;
				}
				length++;
			} else {
				length = -1;
			}
		}
		
		if (valid) {
			str += "occurs within [";
		} else {
			str += "does not occur within [";
		}
		
		for (int i = 0; i < this.seq2.length; i++) {
			str += this.seq2[i];
			if (i < this.seq2.length - 1) {
				str += ", ";
			}
		}
		
		return str + "]";
		
	}

}
