package com.company.model;

public class Feedback {
    private Long idFeedback;
    private Long idClient;
    private String message;

    public Feedback() {
    }

    public Feedback(Long idClient, String message) {
        this.idClient = idClient;
        this.message = message;
    }

    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Long getIdCustomer() {
        return idClient;
    }

    public void setIdCustomer(Long idClient) {
        this.idClient = idClient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "idFeedback=" + idFeedback +
                ", idClient=" + idClient +
                ", message='" + message + '\'' +
                '}';
    }
}
