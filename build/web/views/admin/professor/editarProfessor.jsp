<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Professor</title>
</head>
<body>
<h1>${professor == null ? "Cadastrar Novo Professor" : "Editar Professor"}</h1>
<form action="ProfessorController" method="post">
    <input type="hidden" name="action" value="salvar">
    <input type="hidden" name="id" value="${professor.id}">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${professor.nome}" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${professor.email}" required><br><br>
    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" value="${professor.cpf}" required><br><br>
    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" value="${professor.senha}" required><br><br>
    <button type="submit">Salvar</button>
</form>
<a href="ProfessorController?action=listar">Voltar</a>
</body>
</html>