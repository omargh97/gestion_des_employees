package gestion_des_employees;

public class Employe {
	private String nom;
	private String prenom;
	private int matricule;
	private String sexe;
	private double note;
	private String service;
	private String date_eval;
	private String historique_maladie;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDate_eval() {
		return date_eval;
	}
	public void setDate_eval(String date_eval) {
		this.date_eval = date_eval;
	}
	public String getHistorique_maladie() {
		return historique_maladie;
	}
	public void setHistorique_maladie(String historique_maladie) {
		this.historique_maladie = historique_maladie;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(String nom, String prenom, int matricule, String sexe, double note, String service, String date_eval,
			String historique_maladie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.sexe = sexe;
		this.note = note;
		this.service = service;
		this.date_eval = date_eval;
		this.historique_maladie = historique_maladie;
	}
	
	
	

}
