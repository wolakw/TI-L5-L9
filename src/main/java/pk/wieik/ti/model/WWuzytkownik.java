package pk.wieik.ti.model;

import java.util.HashMap;

public class WWuzytkownik {
    private String login = "";
    private String haslo = "";
    private int uprawnienia = -1;
    // -1 użytkownik niezalogowany
    // 1 użytkownik zalogowany
    // 2 administrator
    private String imie = "";
    private String nazwisko = "";
    private int wiek = -1;

    public HashMap<String, WWuzytkownik> uzytkownicy = new HashMap<>();

    public WWuzytkownik() {
    }

    public WWuzytkownik(String login, String haslo, int uprawnienia) {
        this.login = login;
        this.haslo = haslo;
        this.uprawnienia = uprawnienia;
    }

    public String filtruj(String wejscie) {
        StringBuffer filtrowanie = new StringBuffer();
        char c;

        for (int i=0; i<wejscie.length(); i++) {
            c = wejscie.charAt(i);
            switch (c) {
                case  '<': filtrowanie.append("&lt;"); break;
                case  '>': filtrowanie.append("&gt;"); break;
                case  '"': filtrowanie.append("&quot;"); break;
                case  '&': filtrowanie.append("&amp;"); break;
                default: filtrowanie.append(c);
            }
        }
        return filtrowanie.toString();
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = filtruj(imie);
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = filtruj(nazwisko);
    }

    public int getWiek() {
        return wiek;
    }

    public String getWiekS() {
        if (wiek>=0)
            return ""+wiek;
        else return "";
    }

    public void setWiek(int wiek) {
        if (wiek >= 0)
            this.wiek = wiek;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public int getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(int uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public HashMap<String, WWuzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }

    @Override
    public String toString() {
        return "WWuzytkownik{" +
                "login='" + login + '\'' +
                ", hasło='" + haslo + '\'' +
                ", uprawnienia=" + uprawnienia +
                '}';
    }
}
