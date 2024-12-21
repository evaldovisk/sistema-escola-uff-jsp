/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

/**
 *
 * @author evaldovisk
 */

import entidade.Disciplina;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DisciplinaDAO;

@WebServlet(name = "DisciplinaController", urlPatterns = {"/DisciplinaController"})
public class DisciplinaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            DisciplinaDAO dao = new DisciplinaDAO();

            if ("listar".equals(action)) {
                ArrayList<Disciplina> lista = dao.listar();
                request.setAttribute("disciplinas", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("listarDisciplinas.jsp");
                dispatcher.forward(request, response);
            } else if ("excluir".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id);
                response.sendRedirect("DisciplinaController?action=listar");
            } else if ("editar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Disciplina disciplina = dao.obter(id);
                request.setAttribute("disciplina", disciplina);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editarDisciplina.jsp");
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
            DisciplinaDAO dao = new DisciplinaDAO();

            if ("salvar".equals(action)) {
                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                int cargaHoraria = Integer.parseInt(request.getParameter("carga_horaria"));
                Disciplina disciplina = new Disciplina(nome, descricao, cargaHoraria);

                String idStr = request.getParameter("id");
                if (idStr == null || idStr.isEmpty()) {
                    dao.inserir(disciplina);
                } else {
                    disciplina.setId(Integer.parseInt(idStr));
                    dao.alterar(disciplina);
                }
                response.sendRedirect("DisciplinaController?action=listar");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
