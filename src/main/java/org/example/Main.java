package org.example;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Customer ivan = new Customer("Иван", 23, "1523", Customer.Gender.values()[0]);
        Shop.customers.add(ivan);
        Customer maria = new Customer("Мария", 45, "4878", Customer.Gender.values()[1]);
        Shop.customers.add(maria);
        Customer dmitry = new Customer("Дмитрий", 20, "1235", Customer.Gender.values()[0]);

        Product toy1 = new Product("Игрушка", 3000);
        Shop.products.add(toy1);
        Product toy2 = new Product("Игрушка", 3000);
        Shop.products.add(toy2);
        Product toy3 = new Product("Игрушка", 3000);
        Shop.products.add(toy3);
        Product toy4 = new Product("Игрушка", 3000);
        Shop.products.add(toy4);
        Product toy5 = new Product("Игрушка", 3000);
        Shop.products.add(toy5);
        Product puzzle = new Product("Пазл", 6000);

        Shop.orders.add(Shop.getProduct(ivan, toy2, 3));
        Shop.orders.add(Shop.getProduct(dmitry, puzzle, 2));
        Shop.orders.add(Shop.getProduct(ivan, toy3, 1));
        Shop.orders.add(Shop.getProduct(ivan, puzzle, 5));
        Shop.orders.add(Shop.getProduct(ivan, toy5, 4));
        Shop.orders.add(Shop.getProduct(maria, toy4, 0));

        Shop.orders.removeIf(Objects::isNull);
        System.out.println("Итоговое кол-во сформированных заказов = " + Shop.orders.size());
    }
}
