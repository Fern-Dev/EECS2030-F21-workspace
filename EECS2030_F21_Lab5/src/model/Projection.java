package model;

public class Projection extends BinarySeqOperation {
	
	private int[] seq1;
	private int[] seq2;

	public Projection(int[] seq1, int[] seq2) {
		this.seq1 = seq1;
		this.seq2 = seq2;
	}
	
	public int[] getArray() {
		int[] projection = new int[0];
		
		for (int i = 0; i < seq2.length; i ++) {
			for (int j = 0; j < seq1.length; j ++) {
				if (seq2[i] == seq1[j]) {
					projection = new int[projection.length + 1];
					break;
				}
			}
		}
		
		int counter = 0;
		for (int i = 0; i < seq2.length; i ++) {
			for (int j = 0; j < seq1.length; j ++) {
				if (seq2[i] == seq1[j]) {
					projection[counter] = seq2[i];
					counter++;
					break;
				}
			}
		}
		
		return projection;
	}
	
	public boolean isValid() {
		return false;
	}
	
	public String toString() {
		String str = "Projecting [";
		for (int i = 0; i < this.seq1.length; i++) {
			str += this.seq1[i];
			if (i < this.seq1.length - 1) {
				str += ", ";
			}
		}
		str += "] to [";
		for (int i = 0; i < this.seq2.length; i++) {
			str += this.seq2[i];
			if (i < this.seq2.length - 1) {
				str += ", ";
			}
		}
		str += "] results in: [";
		
		for (int i = 0; i < seq2.length; i ++) {
			for (int j = 0; j < seq1.length; j ++) {
				if (seq2[i] == seq1[j]) {
					str += seq2[i];
					if (i < this.seq2.length - 1) {
						str += ", ";
					}
					break;
				}
			}
		}
		
		return str + "]";
		
	}

}
