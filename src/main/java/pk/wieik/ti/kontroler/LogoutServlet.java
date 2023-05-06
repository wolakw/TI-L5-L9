package pk.wieik.ti.kontroler;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pk.wieik.ti.model.Narzedzia;
import pk.wieik.ti.model.WWuzytkownik;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LS", value = "/LS")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession sejsa = request.getSession();

        WWuzytkownik uzytkownik = (WWuzytkownik) sejsa.getAttribute("uzytkownik");
        if (uzytkownik == null) {
            uzytkownik = new WWuzytkownik();
            sejsa.setAttribute("uzytkownik", uzytkownik);
        }

        sejsa.invalidate();
        response.sendRedirect("WW?strona=glowna");
    }
}
