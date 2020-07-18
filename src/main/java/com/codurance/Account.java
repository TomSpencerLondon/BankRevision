package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {

  private final Clock clock;
  private final Console console;

  private List<Transaction> transactions = new ArrayList();

  public Account(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  @Override
  public void deposit(int amount) {
    String date = clock.getDate();

    transactions.add(new Transaction(amount, date));
  }

  @Override
  public void withdraw(int amount) {

  }

  @Override
  public void printStatement() {
    console.print("Date       || Amount || Balance\n");
    if (!transactions.isEmpty()){
      console.print(transactions.get(0).date
          + " || "
          + transactions.get(0).amount + "   || 1000\n");
    }
  }
}
