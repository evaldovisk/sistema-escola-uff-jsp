<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Professores</title>
</head>
<body>
<h1>Listar Professores</h1>
<a href="editarProfessor.jsp">Cadastrar Novo Professor</a>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="professor" items="${professores}">
            <tr>
                <td>${professor.id}</td>
                <td>${professor.nome}</td>
                <td>${professor.email}</td>
                <td>${professor.cpf}</td>
                <td>
                    <a href="ProfessorController?action=editar&id=${professor.id}">Editar</a>
                    <a href="ProfessorController?action=excluir&id=${professor.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>