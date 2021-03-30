<%@ page import="com.github.paintxd.aulaVI.Contato" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contato Cadastro</title>
</head>
<body>
<%
    List<Contato> agenda;
    if (session.getAttribute("agenda") == null) {
        agenda = new ArrayList<>();
        session.setAttribute("agenda", agenda);
    } else
        agenda = (List<Contato>) session.getAttribute("agenda");

    Contato contato = new Contato();
    contato.setNome(request.getParameter("nome"));
    contato.setNumero(request.getParameter("numero"));
    agenda.add(contato);
%>

<h1>Contato <%= contato.getNome() %> cadastrado</h1>
<button><a style="text-decoration: none" href="agendaContatos.jsp">VAMO</a></button>
</body>
</html>
