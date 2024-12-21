package controller.admin;

import entidade.Professor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProfessorDAO;

@WebServlet(name = "ProfessorController", urlPatterns = {"/ProfessorController"})
public class ProfessorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            ProfessorDAO dao = new ProfessorDAO();

            if ("listar".equals(action)) {
                ArrayList<Professor> lista = dao.listar();
                request.setAttribute("professores", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listarProfessores.jsp");
                dispatcher.forward(request, response);
            } else if ("excluir".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id);
                response.sendRedirect("ProfessorController?action=listar");
            } else if ("editar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Professor professor = dao.obter(id);
                request.setAttribute("professor", professor);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editarProfessor.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            ProfessorDAO dao = new ProfessorDAO();

            if ("salvar".equals(action)) {
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String cpf = request.getParameter("cpf");
                String senha = request.getParameter("senha");
                Professor professor = new Professor(nome, email, cpf, senha);

                String idStr = request.getParameter("id");
                if (idStr == null || idStr.isEmpty()) {
                    dao.inserir(professor);
                } else {
                    professor.setId(Integer.parseInt(idStr));
                    dao.alterar(professor);
                }
                response.sendRedirect("ProfessorController?action=listar");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}