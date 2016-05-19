package server;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.CarAddService;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Антон on 14.05.2016.
 */
public class CarAddServiceImpl extends RemoteServiceServlet implements CarAddService {
    String model;
    String regplate;
    String year;
    String price;

    Connection connection;
    Driver driver;
    String query;

    final String url = "jdbc:mysql://localhost:3306/mydb";
    final String login = "root";
    final String password = "root";

    @Override
    public void update() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model = req.getParameter("model");
        regplate = req.getParameter("regplate");
        year = req.getParameter("year");
        price = req.getParameter("price");

        query = "INSERT INTO cars(model, regplate, year, price) VALUES('" + model + "', '" + regplate
                + "', " + Integer.valueOf(year) + ", " + Integer.valueOf(price) + ");";

        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(url, login, password);

            Statement statement = connection.createStatement();
            statement.execute(query);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}