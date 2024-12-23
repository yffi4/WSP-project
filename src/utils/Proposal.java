package utils;

import java.util.Date;

public class Proposal {
    private String title; // Название предложения
    private String description; // Описание идеи исследования

    private Date submissionDate; // Дата подачи предложения
    private boolean isApproved; // Одобрено ли предложение

    // Конструктор
    public Proposal(String title, String description,  Date submissionDate) {
        this.title = title;
        this.description = description;

        this.submissionDate = submissionDate;
        this.isApproved = false; // Предложение по умолчанию не одобрено
    }

    // Геттеры и сеттеры

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
