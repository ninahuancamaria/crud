package vallegrande.edu.pe.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

        private static final String URL = "jdbc:mysql://floreriamodel.cj6nllkt9hcx.us-east-1.rds.amazonaws.com:3306/floreria_db";
        private static final String USER = "admin";
        private static final String PASSWORD = "floreriamodel";

        public static Connection conectar() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


