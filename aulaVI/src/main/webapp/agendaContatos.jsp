<%@ page import="com.github.paintxd.aulaVI.Contato" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda Contatos</title>
    <style>
        table, th, td {
            border: 1px solid #000000;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<button><a style="text-decoration: none;" href="index.jsp">Retornar</a></button>
<p></p>
<%
    List<Contato> agenda;
    if (session.getAttribute("agenda") == null)
        agenda = new ArrayList<>();
    else
        agenda = (List<Contato>) session.getAttribute("agenda");
%>
<form action="agendaCadastro.jsp" method="post">
    <p>Nome: <input type="text" name="nome"></p>
    <p>Numero: <input type="text" name="numero"></p>
    <button type="submit">Adicionar</button>
</form>

<table style="width:20%">
    <tr>
        <th>Nome</th>
        <th>(DDD) Numero</th>
    </tr>
    <%
        for (int i = 0; i < agenda.size(); i++) {
            String ddd = agenda.get(i).getNumero().substring(0, 2);
            String numero = agenda.get(i).getNumero().substring(2);
            out.println("<tr>");
            out.println("<td>  " + agenda.get(i).getNome() + "</td>");
            out.println("<td>" + "(" + ddd + ") " + numero + "</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>
