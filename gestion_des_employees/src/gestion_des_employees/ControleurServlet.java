package gestion_des_employees;

import java.io.IOException;

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
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		    	 
					//2* :recuperer les donnees saisies    
					String nom=request.getParameter("nom");
					String prenom= request.getParameter("prenom");
					int matricule= Integer.parseInt(request.getParameter("matricule"));
					String sexe =request.getParameter("sexe");
					double note =Double.parseDouble(request.getParameter("note"));
					String service = request.getParameter("service");
					String date_eval =request.getParameter("date_eval");
					String historique_maladie =request.getParameter("historique_maladie");
					
					
					//3* : stocker les donnees saisies (ici le  motCle) dans le model
					Employe emp=new Employe(nom,prenom,matricule,sexe,note,service,date_eval,historique_maladie);
					model.setEmploye(emp);
					
		     }}}

}
