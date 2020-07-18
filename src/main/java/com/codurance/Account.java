package com.codurance;

import java.util.ArrayDeque;
import java.util.Deque;

public class Account implements AccountService {

  private final Clock clock;
  private final Console console;

  private final Deque<Transaction> transactions = new ArrayDeque<>();
  private int balance;

  public Account(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  @Override
  public void deposit(int amount) {
    String date = clock.getDate();
    balance += amount;
    transactions.add(new Transaction(amount, date, balance));
  }

  @Override
  public void withdraw(int amount) {
    deposit(-amount);
  }

  @Override
  public void printStatement() {
    int balance = 0;
    console.print("Date       || Amount || Balance\n");

    transactions.descendingIterator()
        .forEachRemaining(t -> print(t));
  }

  private void print(Transaction t) {
    console.print(t.date + " || " + t.amount + "   || " + t.balance + "\n");
  }
}
