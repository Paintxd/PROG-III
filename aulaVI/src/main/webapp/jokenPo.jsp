<%@ page import="java.util.Optional" %>
<%@ page import="com.github.paintxd.aulaVI.JokenPontos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JokenPo</title>
</head>
<body>
<button><a style="text-decoration: none;" href="index.jsp">Retornar</a></button>
<p></p>
<%
    JokenPontos pontos = (JokenPontos) Optional.ofNullable(session.getAttribute("pontos")).orElse(new JokenPontos());
%>
<form action="jokenPoResultado.jsp" method="post">
    <select name="jogada" >
        <option value="papel">Papel</option>
        <option value="pedra">Pedra</option>
        <option value="tesoura">Tesoura</option>
    </select>
    <button type="submit">Jogar</button>
</form>

<h3>Jogador: <%=pontos.getJogador()%> pontos</h3>
<h3>Maquina: <%=pontos.getMaquina()%> pontos</h3>
</body>
</html>
