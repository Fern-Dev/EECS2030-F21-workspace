package composition;

public class LineCollector {
	
	private Line[] lines;
	private int nol;
	
	public LineCollector() {
		// TODO Auto-generated constructor stub
	}
	
	public LineCollector(LineCollector lc) {
		this ();
		for (int i = 0; i < lc.nol; i++) {
			this.addLine(lc.lines[i]);
		}
	}

	public void addLine(Line line) {
		Line[] lines = new Line[this.nol + 1];
		
		for (int i = 0; i < this.nol + 1; i++) {
			if (i == this.nol) {
				lines[i] = new Line(line);
			} else {
				lines[i] = this.lines[i];
			}
		}
		
		this.nol++;
		this.lines = lines;
	}

	public Line getLineAt(int i) {
		return new Line(this.lines[i]);
	}

	public Line[] getLines() {
		Line[] lines = new Line[this.nol];
		
		for (int i = 0; i < this.nol; i++) {
			lines[i] = this.lines[i];
		}
		return lines;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		
		if (obj == null | this.getClass() != obj.getClass()) {
			return false;
		}

		LineCollector other = (LineCollector) obj;
		if (other.nol == this.nol) {
			boolean same = true;
			for (int i = 0; same && i < other.nol; i++) {
				if (!this.lines[i].equals(other.lines[i])) {
					same = false;
				}
			}
			return same;
		}
		return false;
	} 
}
