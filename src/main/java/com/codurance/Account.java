package com.codurance;

public class Account implements AccountService {

  private final Clock clock;
  private final Console console;

  public Account(Clock clock, Console console) {
    this.clock = clock;
    this.console = console;
  }

  @Override
  public void deposit(int amount) {

  }

  @Override
  public void withdraw(int amount) {

  }

  @Override
  public void printStatement() {
    console.print("Date       || Amount || Balance\n");
  }
}
