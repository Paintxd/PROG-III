<%@ page import="com.github.paintxd.aulaVI.Play" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.github.paintxd.aulaVI.JokenPontos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado - JokenPo</title>
</head>
<body>
<%
    JokenPontos pontos;
    if (session.getAttribute("pontos") == null) {
        pontos = new JokenPontos();
        session.setAttribute("pontos", pontos);
    } else {
        pontos = (JokenPontos) session.getAttribute("pontos");
    }

    Random random = new Random();
    int indexJogada = Play.valueOf(request.getParameter("jogada").toUpperCase()).ordinal();
    int randomJogadaMaquina = random.nextInt(3);

    boolean papelPedra = indexJogada == 0 && randomJogadaMaquina == 2;
    boolean pedraPapel = indexJogada == 2 && randomJogadaMaquina == 0;
    if (indexJogada == randomJogadaMaquina)
        out.println("<h1>EMPATE!!</h1>");
    else if (!pedraPapel && indexJogada > randomJogadaMaquina || papelPedra) {
        out.println("<h1>VOCE GANHOU!!</h1>");
        pontos.setJogador();
    }
    else {
        out.println("<h1>VOCE PERDEU!!</h1>");
        pontos.setMaquina();
    }
%>

<h2>Sua jogada: <%=Play.valueOf(request.getParameter("jogada").toUpperCase())%></h2>
<h2>Jogada maquina: <%=Play.values()[randomJogadaMaquina]%></h2>
<p></p>
<button><a style="text-decoration: none" href="jokenPo.jsp">VAMO</a></button>
</body>
</html>
