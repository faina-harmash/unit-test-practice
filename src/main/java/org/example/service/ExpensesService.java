package org.example.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.example.model.Contract;

public class ExpensesService {

  public int calculateContractExpenses(Contract contract) {
    return contract.getSalary() * contract.getAmountOfMonth();
  }

  public int calculateTotalExpenses(List<Contract> contracts) {
    int totalExpenses = 0;

    for (Contract contract : contracts) {
      totalExpenses = totalExpenses + calculateContractExpenses(contract);
    }
    return totalExpenses;
  }


  public int calculateTotalMonthlyExpenses(List<Contract> contracts) {
    return contracts.stream()
        .mapToInt(c -> c.getSalary())
        .sum();
  }

  public double calculateAverageMonthlySalary(List<Contract> contracts) {

    return (double) calculateTotalMonthlyExpenses(contracts) / contracts.size();

  }

  public double calculateAverageMonthlySalaryPrecise(List<Contract> contracts) {
    BigDecimal totalMonthlyExpenses = BigDecimal.valueOf(calculateTotalMonthlyExpenses(contracts));
    BigDecimal amountOfContracts = BigDecimal.valueOf(contracts.size());
    return totalMonthlyExpenses.divide(amountOfContracts, 2, RoundingMode.HALF_UP)
        .doubleValue();
  }


}
