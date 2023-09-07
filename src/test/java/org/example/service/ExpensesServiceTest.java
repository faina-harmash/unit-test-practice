package org.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.data.Offset;
import org.example.model.Contract;
import org.junit.jupiter.api.Test;

class ExpensesServiceTest {

  ExpensesService expensesService = new ExpensesService();


  @Test
  void checkIfSalaryIsZero() {
    Contract contract = new Contract(0, 12, "Josh");
    int finalSalary = expensesService.calculateContractExpenses(contract);

    assertThat(finalSalary)
        .isEqualTo(0);
  }

  @Test
  void checkIfMonthIsZero() {
    Contract contract = new Contract(2000, 0, "Josh");
    int finalSalary = expensesService.calculateContractExpenses(contract);

    assertThat(finalSalary)
        .isEqualTo(0);
  }

  @Test
  void checkSalaryPerMonth() {
    Contract contract = new Contract(2000, 1, "Josh");
    int finalSalary = expensesService.calculateContractExpenses(contract);

    assertThat(finalSalary)
        .isEqualTo(2000);
  }

  @Test
  void checkSalaryPerYear() {
    Contract contract = new Contract(2000, 12, "Josh");
    int finalSalary = expensesService.calculateContractExpenses(contract);

    assertThat(finalSalary)
        .isEqualTo(24000);
  }

  @Test
  void checkTotalExpensesForZeroContractsInList() {
    List<Contract> contracts = new ArrayList<>();
    int totalExpenses = expensesService.calculateTotalExpenses(contracts);

    assertThat(totalExpenses)
        .isEqualTo(0);

  }

  @Test
  void checkTotalExpensesForFewContractsInList() {
    Contract contract1 = new Contract(2000, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);
    int totalExpenses = expensesService.calculateTotalExpenses(contracts);

    assertThat(totalExpenses)
        .isEqualTo(82500);

  }

  @Test
  void checkTotalMonthlyExpensesForFewContractsInList() {
    Contract contract1 = new Contract(2000, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);
    int totalMonthlyExpenses = expensesService.calculateTotalMonthlyExpenses(contracts);

    assertThat(totalMonthlyExpenses)
        .isEqualTo(4500);

  }

  @Test
  void checkAverageMonthlySalaryForFewContractsInList() {
    Contract contract1 = new Contract(2000, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);
    double averageMonthlySalary = expensesService.calculateAverageMonthlySalary(contracts);

    assertThat(averageMonthlySalary)
        .isEqualTo(1500);

  }

  @Test
  void checkAverageMonthlySalaryForFewContractsInList2() {
    Contract contract1 = new Contract(2100, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);
    double averageMonthlySalary = expensesService.calculateAverageMonthlySalary(contracts);

    assertThat(averageMonthlySalary)
        .isEqualTo(1533.33, Offset.offset(0.01));
  }

  @Test
  void checkAverageMonthlySalaryForFewContractsInListPrecise() {
    Contract contract1 = new Contract(2100, 12, "Josh");
    Contract contract2 = new Contract(1500, 15, "Ken");
    Contract contract3 = new Contract(1000, 36, "Bob");
    List<Contract> contracts = new ArrayList<>();
    contracts.add(contract1);
    contracts.add(contract2);
    contracts.add(contract3);
    double averageMonthlySalary = expensesService.calculateAverageMonthlySalaryPrecise(contracts);

    assertThat(averageMonthlySalary)
        .isEqualTo(1533.33);
  }
}