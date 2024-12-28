package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаем маму с именем, фамилией, возрастом и адресом
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        // Создаем сына, передаем фамилию и адрес от мамы
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        // Печатаем информацию о маме и сыне
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Попытка создать объект без обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Попытка установить некорректный возраст
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
