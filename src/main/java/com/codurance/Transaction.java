package com.codurance;

public class Transaction {

  public int amount;
  public String date;
  public int balance;

  public Transaction(int amount, String date, int balance) {
    this.amount = amount;
    this.date = date;
    this.balance = balance;
  }
}
