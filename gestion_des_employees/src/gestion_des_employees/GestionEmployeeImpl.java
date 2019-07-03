package gestion_des_employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class GestionEmployeeImpl implements IEmploye {

	@Override
	public void addEmploye(Employe e) {
		// TODO Auto-generated method stub
		Connection connec = ConnectionDB.getConnection();
		
		try {
			
			java.sql.PreparedStatement ps = connec.prepareStatement("insert into employe values (?,?,?,?,?,?,?,?) ");
			
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setInt(3, e.getMatricule());
			ps.setString(4, e.getSexe()); 
			ps.setDouble(5, e.getNote()); 
			ps.setString(6, e.getService()); 
			ps.setString(7, e.getDate_eval()); 
			ps.setString(8, e.getHistorique_maladie()); 
			
			ps.executeUpdate(); 
			 
			ps.close();   
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Employe> listeEmploye() {
		// TODO Auto-generated method stub
		ArrayList<Employe> employes=new ArrayList<Employe>(); 
				try {
					
					java.sql.PreparedStatement pr = ConnectionDB.getConnection().prepareStatement("SELECT * FROM  employe");
					 
					ResultSet rs = pr.executeQuery();
					
					while (rs.next()) {
						Employe em=new Employe();						
						em.setNom(rs.getString("nom"));
						em.setPrenom(rs.getString("prenom"));
						em.setMatricule(rs.getInt("matricule"));
						em.setSexe(rs.getString("sexe"));
						em.setNote(rs.getDouble("note"));
						em.setService(rs.getString("service"));
						em.setDate_eval(rs.getString("date_eval"));
						em.setHistorique_maladie(rs.getString("historique_maladie"));
						
						employes.add(em); 
						
					}
					
					pr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return employes;
	}

	@Override
	public ArrayList<Employe> EmployeParMC(String mot_cle) {
		// TODO Auto-generated method stub
		ArrayList<Employe> employes=new ArrayList<Employe>(); 
		try {
			
			java.sql.PreparedStatement pr = ConnectionDB.getConnection().prepareStatement("SELECT * FROM  employe where nom like ?");
			pr.setString(1, "%"+mot_cle+"%"); 
			ResultSet rs = pr.executeQuery();
			
			while (rs.next()) {
				Employe em=new Employe();						
				em.setNom(rs.getString("nom"));
				em.setPrenom(rs.getString("prenom"));
				em.setMatricule(rs.getInt("matricule"));
				em.setSexe(rs.getString("sexe"));
				em.setNote(rs.getDouble("note"));
				em.setService(rs.getString("service"));
				em.setDate_eval(rs.getString("date_eval"));
				em.setHistorique_maladie(rs.getString("historique_maladie"));
				
				employes.add(em); 
				
			}
			
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
return employes;
	}

	@Override
	public Employe getEmploye(int mat) {
		// TODO Auto-generated method stub
		Employe em=null;
		
		try {
			
			java.sql.PreparedStatement pr = ConnectionDB.getConnection().prepareStatement("SELECT * FROM  employe where matricule like ?");
			pr.setInt(1, mat); 
			ResultSet rs = pr.executeQuery();
			
			if (rs.next()) {
			    em=new Employe();						
				em.setNom(rs.getString("nom"));
				em.setPrenom(rs.getString("prenom"));
				em.setMatricule(rs.getInt("matricule"));
				em.setSexe(rs.getString("sexe"));
				em.setNote(rs.getDouble("note"));
				em.setService(rs.getString("service"));
				em.setDate_eval(rs.getString("date_eval"));
				em.setHistorique_maladie(rs.getString("historique_maladie"));
				
			}
			
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(em==null)
			throw new RuntimeException("Employe "+mat+" introuvable !!!");
		return em;
	}

	@Override
	public void updateEmploye(Employe e) {
		// TODO Auto-generated method stub
Connection connec = ConnectionDB.getConnection();
		
		try {
			
			java.sql.PreparedStatement ps = connec.prepareStatement("update employe set nom=? prenom=? sexe=? note=? service=? date_eval=? historique_maladi=? where matricule=?");
			
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getSexe()); 
			ps.setDouble(4, e.getNote()); 
			ps.setString(5, e.getService()); 
			ps.setString(6, e.getDate_eval()); 
			ps.setString(7, e.getHistorique_maladie()); 
			ps.setInt(8, e.getMatricule());
			ps.executeUpdate(); 
			 
			ps.close();   
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmploye(int mat) {
		// TODO Auto-generated method stub
Connection connec = ConnectionDB.getConnection();
		
		try {
			
			java.sql.PreparedStatement ps = connec.prepareStatement("delete from employe where matricule=?");
			 
			ps.setInt(1, mat);
			ps.executeUpdate(); 
			 
			ps.close();   
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
		
	}

}
