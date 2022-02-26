package products;

public abstract class Product {
  String name;
  String brand;
  Double price;

  public String getName() {
    return name;
  }

  public String getBrand() {
    return brand;
  }

  public Double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
