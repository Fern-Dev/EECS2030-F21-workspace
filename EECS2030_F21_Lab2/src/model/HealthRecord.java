package model;

public class HealthRecord {
	
	private String patient_name;
	
	private Vaccine[] doses;
	private String[] vaccination_site;
	private String[] date;
	private int nod;
	
	private String receipt_status;
	private String appointment_status;

	public HealthRecord(String patient_name, int doses_limit) {
		this.patient_name = patient_name;
		this.doses = new Vaccine[doses_limit];
		this.vaccination_site = new String[doses_limit];
		this.date = new String[doses_limit];
		
		this.receipt_status = patient_name + " has not yet received any doses.";
		this.appointment_status = "No vaccination appointment for " + patient_name + " yet";
	}
	
	public String getName() {
		return this.patient_name;
	}

	public String getVaccinationReceipt() {
		return this.receipt_status;
	}

	public String getAppointmentStatus() {
		return this.appointment_status;
	}
	
	public void addAppointment(String appointment) {
		this.appointment_status = appointment;
	}

	public void addRecord(Vaccine vaccine, String vaccination_site, String date) {
		this.doses[this.nod] = vaccine;
		this.vaccination_site[this.nod] = vaccination_site;
		this.date[this.nod] = date;
		this.nod++;
		
		//Number of doses Alan has received: 1 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-20-2021]
		String str = "Number of doses " + this.patient_name + " has received: " + this.nod + " [";
		
		for (int i = 0; i < this.nod; i++) {
			if (this.doses[i].isRecognized()) {
				str += "Recognized vaccine: ";
			} else {
				str += "Unrecognized vaccine: ";
			}
			str += this.doses[i].getCodename() + " (" + this.doses[i].getType() + "; " + this.doses[i].getManufaturer() + ") in " 
					+ this.vaccination_site[i] + " on " + this.date[i];
			
			if (i < this.nod - 1) {
				str += "; ";
			}
		}
		str += "]";
		
		this.receipt_status = str;
	}

}
