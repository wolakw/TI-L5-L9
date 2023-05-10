<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    WWuzytkownik uzytkownik = (WWuzytkownik) session.getAttribute("uzytkownik");
    if (uzytkownik == null) {
        uzytkownik = new WWuzytkownik();
        session.setAttribute("uzytkownik", uzytkownik);
    }
%>
<form id="zapis" action="WW" method="post">
    Imię: <input value="<%=uzytkownik.getImie()%>" type="text" id="imie"  name="i"><br/>
    Nazwisko: <input value="<%=uzytkownik.getNazwisko()%>" type="text" id="naz"  name="n"><br/>
    Wiek: <input value="<%=uzytkownik.getWiek()%>" type="number" id="wiek"  name="w"><br/>
    <div id="przycisk">
        <input type="submit" id="zaloguj" value="Zapisz" name="button">
    </div>
</form>