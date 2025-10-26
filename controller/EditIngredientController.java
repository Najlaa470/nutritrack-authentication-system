package ma.ac.esi.nutritrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.nutritrack.service.EditIngredientService;

import java.io.IOException;

/**
 * Servlet implementation class EditIngredientController
 */
@WebServlet("/EditIngredientController")
public class EditIngredientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditIngredientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		EditIngredientService ingrediantService = new EditIngredientService();
		int ingredientId = Integer.parseInt(request.getParameter("ingredient1"));
		String ingredientName = request.getParameter("nameIng1");
		int ingredientCal = Integer.parseInt(request.getParameter("caloriesIng1"));
		boolean flag = ingrediantService.editIngredient(ingredientId,ingredientName,ingredientCal);
		if(flag) {
			response.sendRedirect("MealController");
		}
		else {
			response.sendRedirect("error.html");
		}
	}

}

