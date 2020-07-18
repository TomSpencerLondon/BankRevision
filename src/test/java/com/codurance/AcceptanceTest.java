package com.codurance;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//Given a client makes a deposit of 1000 on 10-01-2012
//    And a deposit of 2000 on 13-01-2012
//    And a withdrawal of 500 on 14-01-2012
//    When they print their bank statement
//    Then they would see:
//
//    Date       || Amount || Balance
//    14/01/2012 || -500   || 2500
//    13/01/2012 || 2000   || 3000
//    10/01/2012 || 1000   || 1000

@ExtendWith(MockitoExtension.class)
public class AcceptanceTest {
  @Mock
  Clock clock;

  @Mock
  Console console;
  
  private AccountService account;

  @BeforeEach
  void setUp() {
    account = new Account(clock, console);
  }

  @Test
  void prints_statement() {
    account.printStatement();

    then(console)
        .should(times(1))
        .print("Date       || Amount || Balance\n");
  }

  @Test
  void prints_one_transaction() {
    given(clock.getDate()).willReturn("10/01/2012");

    account.deposit(1000);
    account.printStatement();

    then(console)
        .should().print(
            "Date       || Amount || Balance\n" +
                "10/01/2012 || 1000   || 1000\n");
  }
}
