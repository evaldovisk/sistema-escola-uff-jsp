package controller.admin;

import entidade.Turma;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TurmaDAO;

@WebServlet(name = "TurmaController", urlPatterns = {"/TurmaController"})
public class TurmaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            TurmaDAO dao = new TurmaDAO();

            if ("listar".equals(action)) {
                ArrayList<Turma> lista = dao.listar();
                request.setAttribute("turmas", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listarTurmas.jsp");
                dispatcher.forward(request, response);
            } else if ("excluir".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id);
                response.sendRedirect("TurmaController?action=listar");
            } else if ("editar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Turma turma = dao.obter(id);
                request.setAttribute("turma", turma);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editarTurma.jsp");
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
            TurmaDAO dao = new TurmaDAO();

            if ("salvar".equals(action)) {
                String nome = request.getParameter("nome");
                String semestre = request.getParameter("semestre");
                int disciplinaId = Integer.parseInt(request.getParameter("disciplinaId"));
                int professorId = Integer.parseInt(request.getParameter("professorId"));
                Turma turma = new Turma(nome, semestre, disciplinaId, professorId);

                String idStr = request.getParameter("id");
                if (idStr == null || idStr.isEmpty()) {
                    dao.inserir(turma);
                } else {
                    turma.setId(Integer.parseInt(idStr));
                    dao.alterar(turma);
                }
                response.sendRedirect("TurmaController?action=listar");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}