package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Contract;
import org.example.service.ExpensesService;

public class Main {

  public static void main(String[] args) {

    //TODO 1. salary 2k & amount of months = 12
    //TODO 2. salary 1.5k & amount of months = 15
    //TODO 3. salary 1k & amount of months = 36
    //TODO 4. calculate total expenses
    //TODO 5. calculate total Monthly expenses (1 month) for all contracts
    //TODO 6. calculate total average Monthly expenses (1 month) for all contracts
    //TODO 7. calculate total average Monthly expenses (1 month) for all contracts

    Contract contract1 = new Contract(2000, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");

    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);

    ExpensesService expensesService = new ExpensesService();

    int finalSalary1 = expensesService.calculateContractExpenses(contract1);
    int finalSalary2 = expensesService.calculateContractExpenses(contract2);
    int finalSalary3 = expensesService.calculateContractExpenses(contract3);

    int totalExpenses = expensesService.calculateTotalExpenses(contracts);

    System.out.println("finalSalary1 - " + finalSalary1);
    System.out.println("finalSalary2 - " + finalSalary2);
    System.out.println("finalSalary3 - " + finalSalary3);
    System.out.println("totalExpenses - " + totalExpenses);

  }


}
