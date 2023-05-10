<%@ page import="pk.wieik.ti.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>

<form id="zapis" action="WW" method="post">
    Imię: <input value="${uzytkownik.imie}" type="text" id="imie"  name="i"><br/>
    Nazwisko: <input value="${uzytkownik.nazwisko}" type="text" id="naz"  name="n"><br/>
    Wiek: <input value="${uzytkownik.wiekS}" type="number" id="wiek"  name="w"><br/>
    <div id="przycisk">
        <input type="submit" id="zaloguj" value="Zapisz" name="button">
    </div>
</form>