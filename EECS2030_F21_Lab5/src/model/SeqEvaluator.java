package model;

public class SeqEvaluator {
	
	protected SeqOperation[] sequences;
	protected int nos;

	public void addOperation(String string, int[] seq1, int[] seq2) throws IllegalOperationException {
		if (string.equals("op:projection")) {
			this.sequences[this.nos] = new Projection(seq1, seq2);
			this.nos++;
		} else if (string.equals("op:sumsOfPrefixes")) {
			this.sequences[this.nos] = new SumsOfPrefixes(seq1);
			this.nos++;
		} else if (string.equals("op:occursWithin")) {
			this.sequences[this.nos] = new OccursWithin(seq1, seq2);
			this.nos++;
		} else {
			throw new IllegalOperationException();
		}
	}
		
}
