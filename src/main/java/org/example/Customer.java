package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String fio;
    private int age;
    private String phone;
    private Gender gender;

    public enum Gender {
        Male, Female
    }
}
