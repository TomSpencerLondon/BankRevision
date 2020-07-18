package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {

  private final Clock clock;
  private final Console console;

  private List<Transaction> transactions = new ArrayList<>();

  private int balance;

  public Account(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  @Override
  public void deposit(int amount) {
    String date = clock.getDate();
    balance += amount;
    transactions.add(new Transaction(amount, date));
  }

  @Override
  public void withdraw(int amount) {

  }

  @Override
  public void printStatement() {
    console.print("Date       || Amount || Balance\n");

    transactions.forEach(this::print);
  }

  private void print(Transaction t) {
    console.print(t.date + " || " + t.amount + "   || " + balance + "\n");
  }
}
