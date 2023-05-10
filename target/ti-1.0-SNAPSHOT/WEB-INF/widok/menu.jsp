<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    WWuzytkownik uzytkownik = (WWuzytkownik) session.getAttribute("uzytkownik");
    if (uzytkownik == null) {
        uzytkownik = new WWuzytkownik();
        session.setAttribute("uzytkownik", uzytkownik);
    }
%>
<ul>
    <li><a href="?strona=glowna">Strona główna</a></li>
    <li><a href="?strona=kwadratowe">ax<sup>2</sup>+bx+c</a></li>
    <li><a href="?strona=trzecia">Link3</a></li>
    <% if (uzytkownik.getUprawnienia() > 0) { %>
    <li><a href="?strona=ustawienia">Ustawienia</a></li>
    <% } %>
</ul>
<div id="newsy">
    <% if (uzytkownik.getUprawnienia() < 0) { %>
    <form id="login" action="WW" method="post">
        Login: <input type="text" id="log" class="inputy" name="l"><br/>
        Hasło: <input type="password" id="pass" class="inputy" name="p"><br/>
        <div id="przycisk">
            <input type="submit" id="zaloguj" value="Zaloguj">
        </div>
    </form>
    <% } else { %>
    <form id="login" action="WW" method="post">
        <div id="przycisk2">
            Jesteś zalgowany jako <b><%=uzytkownik.getLogin()%></b>
            <input type="submit" id="wyloguj" value="Wyloguj">
        </div>
    </form>
    <% } %>
    <p id="news1"></p>
    <p id="news2"></p>
</div>