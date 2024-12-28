package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address = null;

    // Конструктор без возраста
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Конструктор с возрастом
    public Person(String name, String surname, int age, String address ) {
        this.name = name;
        this.surname = surname;
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    // Метод для проверки наличия возраста
    public boolean hasAge() {
        return age.isPresent();
    }

    // Метод для получения возраста
    public OptionalInt getAge() {
        return age;
    }

    // Метод для установки возраста
    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    // Метод для проверки наличия адреса
//    public boolean hasAddress() {
//        return address != null;
//    }

    // Метод для установки адреса
    public void setAddress(String address) {
        this.address = address;
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для получения фамилии
    public String getSurname() {
        return surname;
    }

    // Метод для получения адреса
    public String getAddress() {
        return address;
    }

    // Метод для создания билдера для ребёнка
    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0);
//                .setAddress(this.address); // Ребенку присваиваем адрес
        if (this.address != null) {
            builder.setAddress(this.address);  // Устанавливаем адрес ребенка
        }
        return builder;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(name + " " + surname);

        age.ifPresent(a -> result.append(", ").append(a).append(" years old"));
        if (address != null) {
            result.append(", lives in ").append(address);
        }

        return result.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + age.orElse(0) + (address != null ? address.hashCode() : 0);
    }
}
