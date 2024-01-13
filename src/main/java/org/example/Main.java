package org.example;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class Main {

    private enum Holidays {
        NoHoliday, NewYear, WomenDay, DefendersDay
    }

    static String currentDate = "23/02";

    public static void Greetings(List<Customer> clients) {
        switch (currentDate) {
            case "31/12" -> {
                System.out.println("Поздравляем с праздником " + Holidays.values()[1] + " следующих покупателей:");
                System.out.println(clients);
            }
            case "23/02" -> {
                System.out.println("Поздравляем с праздником " + Holidays.values()[3] + " следующих покупателей:");
                System.out.println(clients.stream()
                        .filter(e -> e.getGender().equals(Customer.Gender.Male))
                        .toList());
            }
            case "08/03" -> {
                System.out.println("Поздравляем с праздником " + Holidays.values()[2] + " следующих покупателей:");
                System.out.println(clients.stream()
                        .filter(e -> e.getGender().equals(Customer.Gender.Female))
                        .toList());
            }
            default -> System.out.println(Holidays.values()[0] + ", работаем как обычно");
        }
    }

    public static void main(String[] args) throws ParseException {
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
        System.out.println();

        System.out.println("Сегодня " + currentDate);
        Shop.customers.add(dmitry);
        Customer anna = new Customer("Анна", 34, "5612", Customer.Gender.values()[1]);
        Shop.customers.add(anna);
        Greetings(Shop.customers);
    }
}
