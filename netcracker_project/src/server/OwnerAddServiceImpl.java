package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.OwnerAddService;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Антон on 14.05.2016.
 */
public class OwnerAddServiceImpl extends RemoteServiceServlet implements OwnerAddService {
    String firstname;
    String lastname;
    String car;

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
        firstname = req.getParameter("firstname");
        lastname = req.getParameter("lastname");
        car = req.getParameter("car");

        query = "INSERT INTO owners(firstname, lastname, car) VALUES('" + firstname + "', '" + lastname
                + "', '" + car + "');";

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