<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relatório de Notas</title>
</head>
<body>
<h1>Relatório de Notas por Disciplina e Turma</h1>
<table border="1">
    <thead>
        <tr>
            <th>Disciplina</th>
            <th>Turma</th>
            <th>Aluno</th>
            <th>Nota</th>
        </tr>
    </thead>
    <tbody>
        <!-- Itera sobre os objetos relatorio passados do Servlet para a JSP -->
        <c:forEach var="relatorio" items="${relatorio}">
            <tr>
                <td>${relatorio.disciplina}</td>
                <td>${relatorio.turma}</td>
                <td>${relatorio.aluno}</td>
                <td>${relatorio.nota}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>