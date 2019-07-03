package gestion_des_employees;

import java.util.ArrayList;


public class Model {
	private String motCle;
	private ArrayList<Employe> EmployeParMC = new ArrayList<Employe>();
	private Employe emp = new Employe();
	private String action="";   
	private String saveORediter="save";
	
	public String getSaveORediter() {
		return saveORediter;
	}
	public void setSaveORediter(String saveORediter) {
		this.saveORediter = saveORediter;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Employe getEmploye() {
		return emp;
	}
	public void setEmploye(Employe emp) {
		this.emp = emp;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public ArrayList<Employe> getEmployeParMC() {
		return EmployeParMC;
	}
	public void setEmployeParMC(ArrayList<Employe> EmployeParMC) {
		this.EmployeParMC = EmployeParMC;
	}
	

}
