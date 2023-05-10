<%@ page import="pk.wieik.ti.model.Narzedzia" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>
<form id="admin" action="WW" method="post">
  Kolor tła: <input value="${applicationScope.kolorTla}" type="text" id="kolor"  name="k"><br/>
  <div id="przycisk">
    <input type="submit" id="zmien" value="Zmień" name="button">
  </div>
</form>