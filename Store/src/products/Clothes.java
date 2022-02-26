package products;

public class      Clothes extends Product {
  private Size size;
  private String color;

  public Clothes(String name, String brand, double price, Size size, String color) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.size = size;
    this.color = color;
  }

  public Size getSize() {
    return size;
  }

  public String getColor() {
    return color;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public enum Size {
    XS,
    S,
    M,
    L,
    XL
  }

}
