package controller.admin;

import entidade.Aluno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AlunoDAO;
@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AlunoDAO alunoDAO = new AlunoDAO();

        try {
            if ("create".equals(action)) {
                Aluno aluno = new Aluno(
                    request.getParameter("nome"),
                    request.getParameter("email"),
                    request.getParameter("celular"),
                    request.getParameter("cpf"),
                    request.getParameter("senha"),
                    request.getParameter("endereco"),
                    request.getParameter("cidade"),
                    request.getParameter("bairro"),
                    request.getParameter("cep")
                );
                alunoDAO.inserir(aluno);
                response.sendRedirect("AlunoController?action=list");
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Aluno aluno = alunoDAO.obter(id);
                request.setAttribute("aluno", aluno);
                request.getRequestDispatcher("AlunoForm.jsp").forward(request, response);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Aluno aluno = new Aluno(
                    request.getParameter("nome"),
                    request.getParameter("email"),
                    request.getParameter("celular"),
                    request.getParameter("cpf"),
                    request.getParameter("senha"),
                    request.getParameter("endereco"),
                    request.getParameter("cidade"),
                    request.getParameter("bairro"),
                    request.getParameter("cep")
                );
                aluno.setId(id);
                alunoDAO.alterar(aluno);
                response.sendRedirect("AlunoController?action=list");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                alunoDAO.excluir(id);
                response.sendRedirect("AlunoController?action=list");
            } else if ("list".equals(action)) {
                List<Aluno> alunos = alunoDAO.listar();
                request.setAttribute("alunos", alunos);
                request.getRequestDispatcher("AlunoList.jsp").forward(request, response);
            } else {
                response.sendRedirect("AlunoController?action=list");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}