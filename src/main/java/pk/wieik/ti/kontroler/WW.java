package pk.wieik.ti.kontroler;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pk.wieik.ti.model.Narzedzia;
import pk.wieik.ti.model.WWuzytkownik;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WW", value = "/WW")
public class WW extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Integer wartosc = 0;
        Cookie[] ciastka = request.getCookies();
        Cookie licznikCiastko = new Cookie("licznik", "0");
        for (Cookie Ciastko : ciastka) {
            if (Ciastko.getName().equals("licznik"))
                licznikCiastko = Ciastko;
        }
        try {
            wartosc = Integer.parseInt(licznikCiastko.getValue());
        } catch (NumberFormatException e) {
            wartosc = 0;
        }
        wartosc++;

        Cookie licznik = new Cookie("licznik", wartosc.toString());
        licznik.setMaxAge(60 * 60 * 24);
        response.addCookie(licznik);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();

        HttpSession sejsa = request.getSession();

        WWuzytkownik uzytkownik = (WWuzytkownik) sejsa.getAttribute("uzytkownik");
        if (uzytkownik == null) {
            uzytkownik = new WWuzytkownik();
            sejsa.setAttribute("uzytkownik", uzytkownik);
        }

        String szablon = Narzedzia.pobierzSzablon("index.html", context);
        String strona = request.getParameter("strona");

        if (uzytkownik.getUprawnienia() > 0) {
            strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia");
            szablon = Narzedzia.uzupelnij(szablon, "MENU", "menuLogged.html", context);
            szablon = Narzedzia.uzupelnij2(szablon, "USER", uzytkownik.getLogin(), context);
        }
        else {
            strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia");
            szablon = Narzedzia.uzupelnij(szablon, "MENU", "menu.jsp", context);
        }

        szablon = Narzedzia.skrypty(szablon, "pierwsze;kwadratowe");
        szablon = Narzedzia.funkcje(szablon, "podpiecie");

        szablon = Narzedzia.uzupelnij(szablon, "NAGLOWEK", "naglowek.jsp", context);
        szablon = Narzedzia.uzupelnij(szablon, "TRESC", strona + ".html", context);
        szablon = Narzedzia.uzupelnij(szablon, "STOPKA", "stopka.jsp", context);

//        out.println("licznik: " + wartosc);
//        out.println(uzytkownik);
        out.println(szablon);
        out.close();

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

        String button = request.getParameter("button");

        if(button.equals("Zaloguj")) {
            String login = request.getParameter("l");
            String pass = request.getParameter("p");

            if (login.equals("user") && pass.equals("user")) {
                uzytkownik.setLogin(login);
                uzytkownik.setHaslo(pass);
                uzytkownik.setUprawnienia(1);
            } else if (login.equals("admin") && pass.equals("admin")) {
                uzytkownik.setLogin(login);
                uzytkownik.setHaslo(pass);
                uzytkownik.setUprawnienia(2);
            } else {
                uzytkownik.setLogin("");
                uzytkownik.setHaslo("");
                uzytkownik.setUprawnienia(-1);
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else if (button.equals("Wyloguj")) {
            sejsa.invalidate();
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else if (button.equals("Zapisz")) {
            String imie = request.getParameter("i");
            String nazwisko = request.getParameter("n");
            String wiek = request.getParameter("w");

            if (imie.equals("") || nazwisko.equals("") || wiek.equals("")) {
                uzytkownik.setImie("");
                uzytkownik.setNazwisko("");
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/?strona=ustawienia"));
            } else {
                int wiekI = Integer.parseInt(wiek);
                uzytkownik.setImie(imie);
                uzytkownik.setNazwisko(nazwisko);
                uzytkownik.setWiek(wiekI);

//                System.out.println(uzytkownik.getImie());
//                System.out.println(uzytkownik.getNazwisko());
//                System.out.println(wiek);
//                System.out.println(wiek.getClass().getName());

                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/?strona=ustawienia"));

            }
        }
        //response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }
}
