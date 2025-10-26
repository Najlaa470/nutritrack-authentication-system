package ma.ac.esi.nutritrack.controller;

import ma.ac.esi.nutritrack.model.Meal;
import ma.ac.esi.nutritrack.service.MealService;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MealController
 */
@WebServlet("/MealController")
public class MealController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MealService mealService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealController() {
        super();
        this.setMealService(new MealService()); // Initialisation du service
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 HttpSession session = request.getSession(false);
   	 if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("index.html");
            return;
        }

   	 MealService mealService = new MealService();
   	 List<Meal> Meals = mealService.getMeals();
   	 request.setAttribute("nbCal",mealService.mealRepository.nbCal);
   	 request.setAttribute("meals", Meals);
   	 request.getRequestDispatcher("meals.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Rediriger les requêtes POST vers doGet
    }

	public MealService getMealService() {
		return mealService;
	}

	public void setMealService(MealService mealService) {
		this.mealService = mealService;
	}
}
