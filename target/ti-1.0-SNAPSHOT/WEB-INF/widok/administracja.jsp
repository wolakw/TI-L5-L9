<%@ page import="pk.wieik.ti.model.Narzedzia" %>
<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>
<form id="admin" action="WW" method="post">
  Kolor tła: <input value="${applicationScope.kolorTla}" type="text" id="kolor"  name="k"><br/>
  <div id="przycisk">
    <input type="submit" id="zmien" value="Zmień" name="button">
  </div>
  <% for (int i = 0; i < uzytkownik.uzytkownicy.size(); i++) { %>
  <b>user</b>:<br/>
  <input type="radio" id="uz" name="upr" value="u">
  <label for="uz">Użytkownik</label>
  <input type="radio" id="ad" name="upr" value="a">
  <label for="ad">Administrator</label>
  <input type="submit" id="zaloguj" value="Nadaj" name="button"><br>
  <% } %>
</form>