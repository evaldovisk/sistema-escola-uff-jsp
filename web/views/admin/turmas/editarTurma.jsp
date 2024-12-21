<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Turma</title>
</head>
<body>
<h1>${turma == null ? "Cadastrar Nova Turma" : "Editar Turma"}</h1>
<form action="TurmaController" method="post">
    <input type="hidden" name="action" value="salvar">
    <input type="hidden" name="id" value="${turma.id}">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${turma.nome}" required><br><br>
    <label for="semestre">Semestre:</label>
    <input type="text" id="semestre" name="semestre" value="${turma.semestre}" required><br><br>
    <label for="disciplinaId">ID da Disciplina:</label>
    <input type="number" id="disciplinaId" name="disciplinaId" value="${turma.disciplinaId}" required><br><br>
    <label for="professorId">ID do Professor:</label>
    <input type="number" id="professorId" name="professorId" value="${turma.professorId}" required><br><br>
    <button type="submit">Salvar</button>
</form>
<a href="TurmaController?action=listar">Voltar</a>
</body>
</html>