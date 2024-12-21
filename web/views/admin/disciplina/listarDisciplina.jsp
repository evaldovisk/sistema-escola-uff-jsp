<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Disciplinas</title>
</head>
<body>
<h1>Listar Disciplinas</h1>
<a href="editarDisciplina.jsp">Cadastrar Nova Disciplina</a>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Carga Horária</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="disciplina" items="${disciplinas}">
            <tr>
                <td>${disciplina.id}</td>
                <td>${disciplina.nome}</td>
                <td>${disciplina.descricao}</td>
                <td>${disciplina.cargaHoraria}</td>
                <td>
                    <a href="DisciplinaController?action=editar&id=${disciplina.id}">Editar</a>
                    <a href="DisciplinaController?action=excluir&id=${disciplina.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>