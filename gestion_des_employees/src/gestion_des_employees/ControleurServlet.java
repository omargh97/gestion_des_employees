package gestion_des_employees;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class ControleurServlet extends HttpServlet {
	private IEmploye emp;
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		emp=new GestionEmployeeImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	    doPost(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    Model model=new Model();
	    		
		String action=request.getParameter("action");
		model.setAction(action);
		
		if( action !="") { 
		
		     if( model.getAction().equals("save")  && request.getParameter("saveORediter").equals("save")) { 
		    	     
					String nom=request.getParameter("nom");
					String prenom= request.getParameter("prenom");
					int matricule= Integer.parseInt(request.getParameter("matricule"));
					String sexe =request.getParameter("sexe");
					double note =Double.parseDouble(request.getParameter("note"));
					String service = request.getParameter("service");
					String date_eval =request.getParameter("date_eval");
					String historique_maladie =request.getParameter("historique_maladie");
					
					
					Employe empl=new Employe(nom,prenom,matricule,sexe,note,service,date_eval,historique_maladie);
					model.setEmploye(empl);
					
					emp.addEmploye(empl);
					
					ArrayList<Employe> allEmployes=emp.listeEmploye();
					model.setEmployeParMC(allEmployes);
		     }
		     else if(model.getAction().equals("save")  && request.getParameter("saveORediter").equals("editer")) {
				 
					
				  
				    Employe EmployeToEdit =	emp.getEmploye( Integer.parseInt(request.getParameter("matriculeEmployeToEdit")) );
				    
				    EmployeToEdit.setNom(request.getParameter("nom"));
				    EmployeToEdit.setPrenom(request.getParameter("prenom"));
				    EmployeToEdit.setSexe(request.getParameter("sexe"));
				    EmployeToEdit.setService(request.getParameter("service"));
				    EmployeToEdit.setDate_eval(request.getParameter("date_eval"));
				    EmployeToEdit.setHistorique_maladie(request.getParameter("historique_maladie"));
				      
					model.setEmploye(EmployeToEdit); 
					
					
					emp.updateEmploye(EmployeToEdit);  
					
					 model.setEmploye(new Employe());  
					 
					ArrayList<Employe> allEmployes=emp.listeEmploye();   
					model.setEmployeParMC(allEmployes);
					
		}
		   else if( model.getAction().equals("delete") ) {  
				
				emp.deleteEmploye(Integer.parseInt(request.getParameter("matricule")));
				 
				ArrayList<Employe> allEmployes=emp.listeEmploye();   
				model.setEmployeParMC(allEmployes);
				
		} 
		   else  if ( model.getAction().equals("chercher")) {   
			
			   String mc=request.getParameter("motCle");
			
			model.setMotCle(mc);  
			ArrayList<Employe> employeParMC =emp.EmployeParMC(mc);
			
			model.setEmployeParMC(employeParMC);
			

			
		} 
		   else if( model.getAction().equals("editer") ) { 
			 
			 
			 model.setSaveORediter("editer");
			 
			 
			 Employe employeToEdit = emp.getEmploye( Integer.parseInt(request.getParameter("matricule")) ); 
			 model.setEmploye(employeToEdit);
			 
			 ArrayList<Employe> allEmployes=emp.listeEmploye();   
			 model.setEmployeParMC(allEmployes);

	    }
	}
	
	
	 request.setAttribute( "model", model );  
	 request.getRequestDispatcher("index.jsp").forward(request,response); 
}
}

