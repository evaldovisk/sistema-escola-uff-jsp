package controller.admin;

import entidade.Aluno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AlunoDAO;

@WebServlet(name = "Aluno", urlPatterns = {"/admin/aluno"})
public class AlunoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        AlunoDAO alunoDao = new AlunoDAO();
        
        try {
            ArrayList<Aluno> alunos = alunoDao.getAlunoAll();
            request.setAttribute("Alunos", alunos);

        } catch (SQLException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/views/admin/aluno/listaAluno.jsp")
                .forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
}
