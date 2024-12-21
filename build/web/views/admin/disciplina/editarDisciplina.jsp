<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Disciplina</title>
</head>
<body>
<h1>${disciplina == null ? "Cadastrar Nova Disciplina" : "Editar Disciplina"}</h1>
<form action="DisciplinaController" method="post">
    <input type="hidden" name="action" value="salvar">
    <input type="hidden" name="id" value="${disciplina.id}">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${disciplina.nome}" required><br><br>
    <label for="descricao">Descrição:</label>
    <textarea id="descricao" name="descricao" required>${disciplina.descricao}</textarea><br><br>
    <label for="carga_horaria">Carga Horária:</label>
    <input type="number" id="carga_horaria" name="carga_horaria" value="${disciplina.cargaHoraria}" required><br><br>
    <button type="submit">Salvar</button>
</form>
<a href="DisciplinaController?action=listar">Voltar</a>
</body>
</html>