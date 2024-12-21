<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    entidade.Aluno aluno = (entidade.Aluno) request.getAttribute("aluno");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title><%= aluno == null ? "Cadastrar Aluno" : "Editar Aluno" %></title>
</head>
<body>
    <div class="container mt-5">
        <h2><%= aluno == null ? "Cadastrar Aluno" : "Editar Aluno" %></h2>
        <form action="AlunoController" method="post">
            <% if (aluno != null) { %>
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= aluno.getId() %>">
            <% } else { %>
                <input type="hidden" name="action" value="create">
            <% } %>
            <div class="mb-3">
                <label for="nome" class="form-label">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" required value="<%= aluno != null ? aluno.getNome() : "" %>">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required value="<%= aluno != null ? aluno.getEmail() : "" %>">
            </div>
            <div class="mb-3">
                <label for="celular" class="form-label">Celular</label>
                <input type="text" class="form-control" id="celular" name="celular" required value="<%= aluno != null ? aluno.getCelular() : "" %>">
            </div>
            <div class="mb-3">
                <label for="cpf" class="form-label">CPF</label>
                <input type="text" class="form-control" id="cpf" name="cpf" required value="<%= aluno != null ? aluno.getCpf() : "" %>">
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input type="password" class="form-control" id="senha" name="senha" required value="<%= aluno != null ? aluno.getSenha() : "" %>">
            </div>
            <div class="mb-3">
                <label for="endereco" class="form-label">Endereço</label>
                <input type="text" class="form-control" id="endereco" name="endereco" value="<%= aluno != null ? aluno.getEndereco() : "" %>">
            </div>
            <div class="mb-3">
                <label for="cidade" class="form-label">Cidade</label>
                <input type="text" class="form-control" id="cidade" name="cidade" value="<%= aluno != null ? aluno.getCidade() : "" %>">
            </div>
            <div class="mb-3">
                <label for="bairro" class="form-label">Bairro</label>
                <input type="text" class="form-control" id="bairro" name="bairro" value="<%= aluno != null ? aluno.getBairro() : "" %>">
            </div>
            <div class="mb-3">
                <label for="cep" class="form-label">CEP</label>
                <input type="text" class="form-control" id="cep" name="cep" value="<%= aluno != null ? aluno.getCep() : "" %>">
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
            <a href="AlunoController?action=list" class="btn btn-secondary">Voltar</a>
        </form>
    </div>
</body>
</html>