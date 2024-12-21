<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Turmas</title>
</head>
<body>
<h1>Listar Turmas</h1>
<a href="editarTurma.jsp">Cadastrar Nova Turma</a>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Semestre</th>
            <th>Disciplina</th>
            <th>Professor</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="turma" items="${turmas}">
            <tr>
                <td>${turma.id}</td>
                <td>${turma.nome}</td>
                <td>${turma.semestre}</td>
                <td>${turma.disciplinaId}</td>
                <td>${turma.professorId}</td>
                <td>
                    <a href="TurmaController?action=editar&id=${turma.id}">Editar</a>
                    <a href="TurmaController?action=excluir&id=${turma.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>