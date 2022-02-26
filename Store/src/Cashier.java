import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.ChronoUnit.DAYS;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Map;
import products.Appliance;
import products.Clothes;
import products.FoodAndBeverage;
import products.Product;

public class Cashier {

  private static final DecimalFormat df = new DecimalFormat("0.00");

  public void printReceipt(Map<Double, Product> cart, LocalDate purchaseDate, LocalTime purchaseTime) {

    System.out.print("Date: " + purchaseDate.toString() + " " + purchaseTime.toString()
        + System.lineSeparator() + "---Products---" + System.lineSeparator());

    Double totalPrice = (double) 0;
    Double totalDiscount = (double) 0;
    Double total = (double) 0;

    for (Map.Entry<Double, Product> productQuantity : cart.entrySet()) {
      Double quantity = productQuantity.getKey();
      Double price = productQuantity.getValue().getPrice();
      Double totalProductPrice =quantity * price;
      Double discountProductPrice = (double) 0;

      if (productQuantity.getValue() instanceof FoodAndBeverage) {
        FoodAndBeverage foodAndBeverage = (FoodAndBeverage) productQuantity.getValue();
        System.out.print(foodAndBeverage.getName() + " " + foodAndBeverage.getBrand() + System.lineSeparator());
        printPriceDetails(quantity, price, totalProductPrice);
        Integer discount = calculateFoodBeverageDiscount(foodAndBeverage, purchaseDate);
        discountProductPrice = calcuateDiscountPrice(discount, totalProductPrice);
        printDiscountDetails(discount, discountProductPrice);
      }

      if (productQuantity.getValue() instanceof Clothes) {
        Clothes clothes = (Clothes) productQuantity.getValue();
        System.out.print(clothes.getName() + " " + clothes.getBrand() + " " + clothes.getSize()
            + " " + clothes.getColor() + System.lineSeparator());
        printPriceDetails(quantity, price, totalProductPrice);
        Integer discount = calculateClothesDiscount(purchaseDate);
        discountProductPrice = calcuateDiscountPrice(discount, totalProductPrice);
        printDiscountDetails(discount, discountProductPrice);
      }

      if (productQuantity.getValue() instanceof Appliance) {
        Appliance appliance = (Appliance) productQuantity.getValue();
        System.out.print(appliance.getName() + " " + appliance.getBrand() + " " + appliance.getModel() + System.lineSeparator());
        printPriceDetails(quantity, price, totalProductPrice);
        Integer discount = calculateAppliancesDiscount(appliance, purchaseDate);
        discountProductPrice = calcuateDiscountPrice(discount, totalProductPrice);
        printDiscountDetails(discount, discountProductPrice);
      }

      totalPrice = totalPrice + totalProductPrice;
      totalDiscount = totalDiscount + discountProductPrice;
      total = totalPrice - totalDiscount;
    }

    System.out.print("-----------------------------------------------------------------------------------" + System.lineSeparator());
    System.out.print("SUBTOTAL: $" + df.format(totalPrice) + System.lineSeparator());
    System.out.print("DISCOUNT: -$" + df.format(totalDiscount) + System.lineSeparator());
    System.out.print("TOTAL: -$" + df.format(total));
  }

  private Integer calculateFoodBeverageDiscount(FoodAndBeverage foodAndBeverage, LocalDate purchaseDate) {
    if (purchaseDate.equals(foodAndBeverage.getExpirationDate())){
      return 70;
    }
    else if (DAYS.between(purchaseDate, foodAndBeverage.getExpirationDate()) <= 5) {
      return 30;
    }
    else return 0;
  }

  private Integer calculateClothesDiscount(LocalDate purchaseDate) {
    if (!MONDAY.equals(purchaseDate.getDayOfWeek()) && !SUNDAY.equals(purchaseDate.getDayOfWeek())) {
      return 10;
    }
    else return 0;
  }

  private Integer calculateAppliancesDiscount(Appliance appliance, LocalDate purchaseDate) {
    if ((SATURDAY.equals(purchaseDate.getDayOfWeek()) || SUNDAY.equals(purchaseDate.getDayOfWeek())) &&
        appliance.getPrice() > 999) {
      return 7;
    }
    else return 0;
  }

  private Double calcuateDiscountPrice(Integer discount, Double price) {
    return ((double) discount / (double) 100) * price;
  }

  private void printPriceDetails(Double quantity, Double price, Double totalProductPrice) {
    System.out.print(quantity+ " x $" + price + " = $" + df.format(totalProductPrice) + System.lineSeparator());
  }

  private void printDiscountDetails(Integer discount, Double discountPrice) {
    if (discount != 0) {
      System.out.print("#discount " + discount + "% -$" + df.format(discountPrice) + System.lineSeparator());
    }
  }

}
