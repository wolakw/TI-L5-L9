package pk.wieik.ti.model;

import jakarta.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Narzedzia {

    public static String pobierzSzablon(String plik, ServletContext context) throws IOException {
        StringBuffer wyjscie = new StringBuffer("");
        String tekst = "";
        InputStream is = context.getResourceAsStream("/WEB-INF/widok/" + plik);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            while ((tekst = reader.readLine()) != null) {
                wyjscie.append(tekst).append("\n");
            }
        } else wyjscie.append("Brak pliku " + plik);
        return wyjscie.toString();
    }

    public static String uzupelnij(String szablon, String znacznik,
                                   String plik, ServletContext context) throws IOException {
        StringBuffer wyjscie = new StringBuffer("");
        String tekst = "";
        InputStream is = context.getResourceAsStream("/WEB-INF/widok/" + plik);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            while ((tekst = reader.readLine()) != null) {
                wyjscie.append(tekst).append("\n");
            }
        } else wyjscie.append("Brak pliku " + plik);

        return szablon.replace("[[" + znacznik + "]]", wyjscie.toString());
    }

    public static String skrypty(String szablon, String wejscie) throws IOException {
        String[] skrypty = wejscie.split(";");
        String wyjscie = "";

        for (int i = 0; i < skrypty.length; i++) {
            wyjscie = wyjscie + "<script type=\"text/javascript\" src=\"" + skrypty[i] +".js\"></script>\n";
        }

        return szablon.replace("[[SKRYPTY]]", wyjscie);
    }

    public static String funkcje(String szablon, String wejscie) throws IOException {
        String[] funkcje = wejscie.split(";");
        String wyjscie = "<body onload=\"funkcje(); zegarek(); setInterval(zegarek, 1000); ";

        for (int i = 0; i < funkcje.length; i++) {
            wyjscie = wyjscie + funkcje[i] + "(); ";
        }

        wyjscie = wyjscie + "\">";

        return szablon.replace("[[FUNKCJE]]", wyjscie);
    }
    public static int parsujInteger(String wejscie, int domyslna) {
        int wyjscie = domyslna;
        try {
            wyjscie = Integer.parseInt(wejscie);
        } catch (NumberFormatException nfe) { // null lub zły format
            wyjscie = domyslna;
        }
        return wyjscie;
    }

    public  static String parsujStrone(String wejscie, String prawidlowe) {
        String wyjscie = "glowna";
        String[] strony = prawidlowe.split(";");
        if (wejscie==null) wejscie="glowna";

        for (String poprawna: strony) {
            if (wejscie.equals(poprawna)) {
                wyjscie = wejscie;
                return wyjscie;
            }
        }
        return  wyjscie;
    }
}