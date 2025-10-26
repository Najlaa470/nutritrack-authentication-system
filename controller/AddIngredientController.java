package ma.ac.esi.nutritrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.nutritrack.service.AddIngredientService;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Controller permettant d'ajouter dynamiquement un ingrédient à un repas.
 */
@WebServlet("/AddIngredientController")
public class AddIngredientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AddIngredientController.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Récupérer les paramètres du formulaire
            int mealId = Integer.parseInt(request.getParameter("mealId"));
            String ingredientName = request.getParameter("nameIng");
            int calories = Integer.parseInt(request.getParameter("caloriesIng"));

            // Appel au service
            AddIngredientService ingredientService = new AddIngredientService();
            boolean success = ingredientService.addIngredientToMeal(mealId, ingredientName, calories);

            if (success) {
                // Redirection vers le MealController, qui charge la liste des repas et forward -> meal.jsp
                response.sendRedirect("MealController?added=true");
            } else {
                LOGGER.warning("Échec de l'ajout de l'ingrédient.");
                response.sendRedirect("error.html");
            }

        } catch (NumberFormatException e) {
            LOGGER.severe("Erreur de parsing des données : " + e.getMessage());
            response.sendRedirect("error.html");
        } catch (Exception e) {
            LOGGER.severe("Exception inattendue : " + e.getMessage());
            response.sendRedirect("error.html");
        }
    }
}
