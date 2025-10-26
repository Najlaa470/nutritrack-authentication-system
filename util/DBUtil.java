package ma.ac.esi.nutritrack.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:postgresql://localhost:5432/nutriwise";
	private static final String USER = "postgres";
	private static final String PASSWORD = "lebonheur";

    public static Connection getConnection() {
        try {
           
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println(" Erreur de connexion à PostgreSQL !");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println(" Le driver PostgreSQL est introuvable !");
            e.printStackTrace();
        }
        return null;
    }

    // Méthode de test
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("✅ Connexion réussie à la base de données !");
        } else {
            System.out.println("⚠️ Connexion échouée.");
        }
    }
}
