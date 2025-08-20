package com.example.OrganaEvent.login; // adapte selon ton nom de package réel

public class LoginRequest {
    private String email;
    private String motDePasse;

    // Constructeurs
    public LoginRequest() {
    }

    public LoginRequest(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
