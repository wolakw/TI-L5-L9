package pk.wieik.ti.model;

public class WWuzytkownik {
    private String login = "";
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
                ", uprawnienia=" + uprawnienia +
                '}';
    }
}
