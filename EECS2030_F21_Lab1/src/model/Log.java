package model;

public class Log {
	
	private String version;
	private int nof = 0;
	private String[] fixes = new String[10];

	public Log(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}

	public int getNumberOfFixes() {
		return this.nof;
	}

	public String getFixes() {
		String str = "[";
		
		for (int i = 0; i < nof; i++) {
			str += fixes[i];		
			if (i != nof - 1) {
				str += ", ";
			}
		}
		
		str += "]";
		
		return str;
	}
	
	public String toString() {
		return "Version " + this.version + " contains " + this.nof + " fixes " + this.getFixes();
	}

	public void addFix(String fix) {
		this.fixes[nof] = fix;
		nof++;
	}

}
