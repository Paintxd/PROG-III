<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Impar - Par</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<button><a style="text-decoration: none;" href="index.jsp">Retornar</a></button>
<p></p>
<%
    List<Long> pares = new ArrayList<>();
    List<Long> impares = new ArrayList<>();

    for (long i = 1; i <= 100; i++) {
        if (i % 2 == 0) {
            pares.add(i);
            continue;
        }
        impares.add(i);
    }
%>

<table style="width:100%">
    <tr>
        <th>Pares</th>
        <th>Impares</th>
    </tr>
    <%
        for (int i = 0; i < 50; i++) {
            out.println("<tr>");
            out.println("<td>" + pares.get(i) + "</td>");
            out.println("<td>" + impares.get(i) + "</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>
