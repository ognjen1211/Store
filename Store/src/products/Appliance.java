package products;

import java.time.LocalDate;

public class Appliance extends Product{
  private String model;
  private LocalDate productionDate;
  private Double weight;

  public Appliance(String name, String brand, Double price, String model, LocalDate productionDate, double weight) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.model = model;
    this.productionDate = productionDate;
    this.weight = weight;
  }

  public String getModel() {
    return model;
  }

  public LocalDate getProductionDate() {
    return productionDate;
  }

  public double getWeight() {
    return weight;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setProductionDate(LocalDate productionDate) {
    this.productionDate = productionDate;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }
}
