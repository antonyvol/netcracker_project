package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.TradeAddService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Антон on 14.05.2016.
 */
public class TradeAddServiceImpl extends RemoteServiceServlet implements TradeAddService {
    String seller;
    String customer;
    String car;
    String date;

    @Override
    public void update() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        seller = req.getParameter("seller");
        customer = req.getParameter("customer");
        car = req.getParameter("car");
        date = req.getParameter("date");

    }
}