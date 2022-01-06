package model;

public class VaccinationSite {
	
	private String site_name;
	
	private VaccineDistribution[] distributions;
	private int doese_limit;
	private int nod;
	private int noa;
	
	private HealthRecord[] people;
	private int nop;

	public VaccinationSite(String site_name, int doses_limit) {
		this.site_name = site_name;
		this.doese_limit = doses_limit;
		this.distributions = new VaccineDistribution[0];
		
		people = new HealthRecord[200];
	}
	
	public String toString() {
		//North York General Hospital has 7 available doses: <4 doses of Moderna, 2 doses of Pfizer/BioNTech, 1 doses of Oxford/AstraZeneca>
		String str = this.site_name + " has " + this.nod + " available doses: <";
		
		for (int i = 0; i < this.distributions.length; i++) {
			str += this.distributions[i].getDoses() + " doses of " + this.distributions[i].getVaccine().getManufaturer();
			
			if (i < this.distributions.length - 1) {
				str += ", ";
			}
		}
		
		str += ">";
		
		return str;
	}

	public int getNumberOfAvailableDoses() {
		return this.nod;
	}

	public int getNumberOfAvailableDoses(String codename) {
		int counter = 0;
		for (int i = 0; i < this.distributions.length; i++) {
			if (this.distributions[i].getVaccine().getCodename().equals(codename)) {
				counter += this.distributions[i].getDoses();
			}
		}
		return counter;
	}

	public void addDistribution(Vaccine vaccine, int doses) throws TooMuchDistributionException, UnrecognizedVaccineCodeNameException {
		if (!vaccine.isRecognized()) {
			throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");
		}
		
		if (doses + this.nod > this.doese_limit) {
			throw new TooMuchDistributionException("Unexpected exception thrown");
		}
		
		for (int i = 0; i < this.distributions.length; i++) {
			if (this.distributions[i].getVaccine().getCodename().equals(vaccine.getCodename())) {
				this.distributions[i].addDoses(doses);
				this.nod += doses;
				this.noa += doses;
				return;
			}
		}
		
		VaccineDistribution[] newDistributions = new VaccineDistribution[this.distributions.length + 1];
		
		for (int i = 0; i < newDistributions.length; i++) {
			if (i == newDistributions.length - 1) {
				newDistributions[i] = new VaccineDistribution(vaccine, doses);
				this.nod += doses;
				this.noa += doses;
			} else {
				newDistributions[i] = this.distributions[i];
			}
		}
		
		this.distributions = newDistributions;
		
	}

	public void bookAppointment(HealthRecord person) throws InsufficientVaccineDosesException{
		if (this.noa > 0) {
			person.addAppointment("Last vaccination appointment for " + person.getName() + " with " + this.site_name + " succeeded");
			this.noa--;
			
			this.people[this.nop] = person;
			this.nop++;
		} else {
			person.addAppointment("Last vaccination appointment for " + person.getName() + " with " + this.site_name + " failed");
			throw new InsufficientVaccineDosesException("Unexpected exception thrown");
		}
	}

	public void administer(String date) {
		int counter = 0;
		for (int i = 0; i < this.distributions.length; i++) {
			for (int i2 = counter; i2 < this.nop; i2++) {
				if (this.distributions[i].getDoses() > 0) {
					this.distributions[i].removeDoses(1);
					this.people[i2].addRecord(this.distributions[i].getVaccine(), this.site_name, date);
					counter++;
					this.nod--;
				} else {
					break;
				}
			}
		}
		this.people = new HealthRecord[200];
		this.nop = 0;
		
	}

}
