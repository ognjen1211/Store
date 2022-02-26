package products;

import java.time.LocalDate;

public class FoodAndBeverage extends Product {
  private LocalDate expirationDate;

  public FoodAndBeverage(String name, String brand, Double price, LocalDate expirationDate) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.expirationDate = expirationDate;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }
}
