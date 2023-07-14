package controller.bookingController;

import dal.VaccineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vaccine;

@WebServlet(urlPatterns = {"/ListVaccineController"})
public class ListVaccineController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String searchValue = request.getParameter("search");

        VaccineDAO dao = new VaccineDAO();
        List<Vaccine> vaccine = dao.getAllVaccine();
        List<Vaccine> searchResults = dao.searchByName(searchValue);

        request.setAttribute("vaccine", searchResults);
        request.setAttribute("vaccine", vaccine);
        request.getRequestDispatcher("/Booking/1.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
