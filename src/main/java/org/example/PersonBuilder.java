package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    // Устанавливаем имя
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // Устанавливаем фамилию
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    // Устанавливаем возраст
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
        return this;
    }

    // Устанавливаем адрес
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Создаем объект Person
    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Name and surname must be provided");
        }

        // Если age был задан, передаем его в конструктор Person
        if (age != null) {
            return new Person(name, surname, age, address);
        } else {
            // Если age не был задан, передаем его как пустой (OptionalInt.empty)
            Person person = new Person(name, surname);

            if (address != null) {
                person.setAddress(address); // Устанавливаем адрес
            }

            return person;
        }
    }
}

