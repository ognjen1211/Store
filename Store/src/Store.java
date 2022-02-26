import products.Appliance;
import products.Clothes;
import products.FoodAndBeverage;
import products.Product;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Store {

    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        FoodAndBeverage food = new FoodAndBeverage("apples", "BrandA", 1.50, LocalDate.of(2021, 6, 14));
        FoodAndBeverage beverage = new FoodAndBeverage("milk", "BrandM", 0.99, LocalDate.of(2022, 2, 2));
        Clothes clothes = new Clothes("T-shirt", "BrandT", 15.99, Clothes.Size.M, "violet");
        Appliance appliance = new Appliance("laptop", "BrandL", (double) 2345, "ModelL", LocalDate.of(2021, 3, 3), 1.125);
        Map<Double, Product> cart = new LinkedHashMap<Double, Product>();
        cart.put(2.45, food);
        cart.put((double) 3, beverage);
        cart.put((double) 2, clothes);
        cart.put((double) 1, appliance);

        cashier.printReceipt(cart, LocalDate.of(2021,6,14), LocalTime.of(12, 34, 56));
    }
}
