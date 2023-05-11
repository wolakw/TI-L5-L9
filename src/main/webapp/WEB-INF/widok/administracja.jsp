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
<%--  <% for (int i = 0; i < uzytkownik.uzytkownicy.size(); i++) { %>--%>
<%--  <b>user</b>:<br/>--%>
<%--  <input type="radio" id="uz" name="upr" value="u">--%>
<%--  <label for="uz">Użytkownik</label>--%>
<%--  <input type="radio" id="ad" name="upr" value="a">--%>
<%--  <label for="ad">Administrator</label>--%>
<%--  <input type="submit" id="zaloguj" value="Nadaj" name="button"><br>--%>
<%--  <% } %>--%>
</form>
<%
  ServletContext aplikacja = request.getServletContext();
  HashMap<String,WWuzytkownik> uzytkownicy = (HashMap<String,WWuzytkownik>) aplikacja.getAttribute("uzytkownicy");
  for(Map.Entry<String,WWuzytkownik> entry : uzytkownicy.entrySet()){
    WWuzytkownik user = entry.getValue();
    String login = user.getLogin();
    int uprawnienia = user.getUprawnienia();
%>
<form name="updateUser" method="post" action="WW">
  <input type="hidden" name="button" value="Update"  />
  <input type="hidden" name="userLogin" value="<%=login%>"  />
  <b><%=login%><b/>:<br>
  <select name = "uprawnienia">
    <%
      if(uprawnienia == 1){
    %>
    <option value = "1">User</option>
    <option value = "2">Admin</option>
    <%
    }
    else{
    %>
    <option value = "admin">Admin</option>
    <option value = "user">User</option>
    <%
      }
    %>
  </select>
  <input type="submit" value="Nadaj" />
</form>
<%
  }
%>