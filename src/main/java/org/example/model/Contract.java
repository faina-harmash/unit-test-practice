package org.example.model;

public class Contract {
  private final int salary;
  private final int amountOfMonth;
  private final String employeeName;

  public Contract(int salary, int amountOfMonth, String employeeName) {
    this.salary = salary;
    this.amountOfMonth = amountOfMonth;
    this.employeeName = employeeName;
  }

  public int getSalary() {
    return salary;
  }

  public int getAmountOfMonth() {
    return amountOfMonth;
  }

  public String getEmployeeName() {
    return employeeName;
  }
}
