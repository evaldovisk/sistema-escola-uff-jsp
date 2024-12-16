<%@page import="entidade.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Aluno</title>
        <link href="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css"  rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../../comum/menu.jsp"/>
        <div class="container">
            <div class="mt-5">
                <%
                    ArrayList<Aluno> alunos = (ArrayList<Aluno>) request.getAttribute("Alunos");
                    for (Aluno aluno : alunos) {%>
                    
                    <h1><%= aluno.getNome()%> </h1>
                    
                  <%  }%>
                <div/>
            </div>

            <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
