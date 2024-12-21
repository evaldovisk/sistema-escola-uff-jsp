package controller.admin;

import entidade.Relatorio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RelatorioDAO;

@WebServlet(name = "RelatorioController", urlPatterns = {"/RelatorioController"})
public class RelatorioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RelatorioDAO relatorioDAO = new RelatorioDAO();
            
            ArrayList<Relatorio> listaRelatorio = relatorioDAO.gerarRelatorio();
            
            request.setAttribute("relatorio", listaRelatorio);

            RequestDispatcher dispatcher = request.getRequestDispatcher("relatorio.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}