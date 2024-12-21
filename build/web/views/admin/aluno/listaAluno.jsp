<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<entidade.Aluno> alunos = (List<entidade.Aluno>) request.getAttribute("alunos");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Lista de Alunos</title>
</head>
<body>
    <div class="container mt-5">
        <h2>Lista de Alunos</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Cidade</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <% for (entidade.Aluno aluno : alunos) { %>
                <tr>
                    <td><%= aluno.getNome() %></td>
                    <td><%= aluno.getEmail() %></td>
                    <td><%= aluno.getCidade() %></td>
                    <td>
                        <a href="AlunoController?action=edit&id=<%= aluno.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="AlunoController?action=delete&id=<%= aluno.getId() %>" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
        <a href="AlunoForm.jsp" class="btn btn-primary">Novo Aluno</a>
    </div>
</body>
</html>