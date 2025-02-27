package com.example.personal.finance.management.Models;



import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("transactionType")
    private String transactionType; // Income or Expense

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    public TransactionModel(int transactionId, int userId, String transactionType, double amount, String category, String notes, Date date) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.category = category;
        this.notes = notes;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionModel() {
    }
}