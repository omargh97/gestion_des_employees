package gestion_des_employees;

public class TestGDE {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		IEmploye gde = new GestionEmployeeImpl();
		
		Employe e1 =new Employe();
		e1.setNom("omar");
		e1.setPrenom("ghaieb");
		e1.setMatricule(1);
		e1.setSexe("homme");
		e1.setNote(8.2);
		e1.setService("dprt info");
		e1.setDate_eval("10/9/2018");
		e1.setHistorique_maladie(" maladie");
		
		Employe e2 =new Employe();
		e2.setNom("foulen");
		e2.setPrenom("fouleni");
		e2.setMatricule(2);
		e2.setSexe("homme");
		e2.setNote(6.5);
		e2.setService("dprt chimie");
		e2.setDate_eval("15/9/2019");
		e2.setHistorique_maladie("pas de maladie");
		
		Employe e3 =new Employe();
		e3.setNom("sofi");
		e3.setPrenom("balbi");
		e3.setMatricule(5);
		e3.setSexe("femme");
		e3.setNote(4.5);
		e3.setService("dprt elec");
		e3.setDate_eval("05/9/2018");
		e3.setHistorique_maladie("pas de maladie");
		
		Employe e31 =new Employe();
		e31.setNom("sofiaaa");
		e31.setPrenom("balbiiiii");
		e31.setMatricule(11);
		e31.setSexe("femme");
		e31.setNote(4.5);
		e31.setService("dprt elec");
		e31.setDate_eval("05/9/2018");
		e31.setHistorique_maladie("pas de maladie");
		
		Employe e32 =new Employe();
		e32.setNom("omr");
		e32.setPrenom("gh");
		e32.setMatricule(12);
		e32.setSexe("homme");
		e32.setNote(4.5);
		e32.setService("dprt info");
		e32.setDate_eval("05/9/2019");
		e32.setHistorique_maladie("pas de maladie");
		
		gde.addEmploye(e1);
		gde.addEmploye(e2);
		gde.addEmploye(e3);
		gde.addEmploye(e31);
		gde.addEmploye(e32);
		gde.deleteEmploye(e1.getMatricule());
		
	}

}
