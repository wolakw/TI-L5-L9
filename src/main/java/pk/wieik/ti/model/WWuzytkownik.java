package pk.wieik.ti.model;

public class WWuzytkownik {
    private String login = "";
    private String haslo = "";
    private int uprawnienia = -1;
    // -1 użytkownik niezalogowany
    // 1 użytkownik zalogowany
    // 2 administrator


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
