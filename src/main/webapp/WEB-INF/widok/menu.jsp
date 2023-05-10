<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>
<ul>
    <li><a href="?strona=glowna">Strona główna</a></li>
    <li><a href="?strona=kwadratowe">ax<sup>2</sup>+bx+c</a></li>
    <li><a href="?strona=trzecia">Link3</a></li>
    ${ (uzytkownik.uprawnienia>0) ? '<li><a href="?strona=ustawienia">Ustawienia</a></li>' : ''}
    <% if (uzytkownik.getUprawnienia() == 2) { %>
    <li><a href="?strona=administracja">Administracja</a></li>
    <% } %>
</ul>
<div id="newsy">
    <% if (uzytkownik.getUprawnienia() < 0) { %>
    <form id="login" action="WW" method="post">
        Login: <input type="text" id="log" class="inputy" name="l"><br/>
        Hasło: <input type="password" id="pass" class="inputy" name="p"><br/>
        <div id="przycisk">
            <input type="submit" id="zaloguj" value="Zaloguj" name="button">
        </div>
    </form>
    <% } else { %>
    <form id="login" action="WW" method="post">
        <div id="przycisk2">
            Jesteś zalgowany jako <b>${uzytkownik.login}</b>
            <input type="submit" id="wyloguj" value="Wyloguj" name="button">
        </div>
    </form>
    <% } %>
    <p id="news1"></p>
    <p id="news2"></p>
</div>