package br.com.murillo.salutar.secutiry;

public class SalutarToken {

    private String token;

    public SalutarToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
