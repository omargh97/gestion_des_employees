package gestion_des_employees;

public class TestGDE {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		IEmploye gde = new GestionEmployeeImpl();
		
		Employe e1 =new Employe();
		e1.setNom("omar");
		e1.setPrenom("ghaieb");
		e1.setMatricule(0001);
		e1.setSexe("homme");
		e1.setNote(8.2);
		e1.setService("dprt info");
		e1.setDate_eval("10/9/2018");
		e1.setHistorique_maladie(" maladie");
		
		Employe e2 =new Employe();
		e2.setNom("foulen");
		e2.setPrenom("fouleni");
		e2.setMatricule(0002);
		e2.setSexe("homme");
		e2.setNote(6.5);
		e2.setService("dprt chimie");
		e2.setDate_eval("15/9/2019");
		e2.setHistorique_maladie("pas de maladie");
		
		gde.addEmploye(e1);
		gde.addEmploye(e2);
	}

}
