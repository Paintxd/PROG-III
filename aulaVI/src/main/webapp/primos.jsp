<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Primos</title>
</head>
<body>
<button><a style="text-decoration: none;" href="index.jsp">Retornar</a></button>
<p></p>
<%
    for (int i = 2; i <= 1000; i++) {
        int c = 0;
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                c++;
                break;
            }
        }
        if (c == 0)
            out.println(i);
    }
%>
</body>
</html>
