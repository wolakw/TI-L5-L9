package pk.wieik.ti.model;

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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    @Override
    public String toString() {
        return "WWuzytkownik{" +
                "login='" + login + '\'' +
                ", hasło='" + haslo + '\'' +
                ", uprawnienia=" + uprawnienia +
                '}';
    }
}
