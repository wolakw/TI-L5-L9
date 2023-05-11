<%@ page import="pk.wieik.ti.model.Narzedzia" %>
<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>
<form id="admin" action="WW" method="post">
  Kolor tła: <input value="${applicationScope.kolorTla}" type="text" id="kolor"  name="k"><br/>
  <div id="przycisk">
    <input type="submit" id="zmien" value="Zmień" name="button">
  </div>
</form>
<%
  ServletContext aplikacja = request.getServletContext();
  HashMap<String,WWuzytkownik> uzytkownicy = (HashMap<String,WWuzytkownik>) aplikacja.getAttribute("uzytkownicy");
  for(Map.Entry<String,WWuzytkownik> entry : uzytkownicy.entrySet()){
    WWuzytkownik wuzytkownik = entry.getValue();
    String login = wuzytkownik.getLogin();
    int uprawnienia = wuzytkownik.getUprawnienia();
%>
<form name="updateUser" method="post" action="WW">
  <input type="hidden" name="button" value="Update"  />
  <input type="hidden" name="uztk" value="<%=login%>"  />
  <b><%=login%></b>:<br>
  <select name = "uprawnienia">
    <%
      if(uprawnienia == 1){
    %>
    <option value ="1">Użytkownik</option>
    <option value ="2">Administrator</option>
    <%
    }
    else{
    %>
    <option value ="1">Administrator</option>
    <option value ="2">Użytkownik</option>
    <%
      }
    %>
  </select>
  <input type="submit" value="Nadaj" />
</form>
<%
  }
%>