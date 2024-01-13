package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static List<Customer> customers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();


    public static Order getProduct(Customer customer, Product product, int quantity) {
        try {
            if (!customers.contains(customer)) {
                throw new CustomerException();
            }
            if (!products.contains(product)) {
                throw new ProductException();
            }
            if ((quantity <= 0) || (quantity > products.size())) {
                throw new AmountException();
            }
            return new Order(customer, product, quantity);
        } catch (CustomerException e) {
            System.err.println(e.getMessage());
        } catch (ProductException e) {
            System.err.println("Товара не существует");
        } catch (AmountException e) {
            System.err.println("Количество задано некорректно");
        }
        return null;
    }
}
