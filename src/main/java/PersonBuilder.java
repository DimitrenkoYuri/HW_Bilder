import java.util.OptionalInt;

public class PersonBuilder {

    private String name;

    private OptionalInt age;
    private String address;

    private String surname;
    Person person;

    public PersonBuilder setName(String name) {
        this.name = name;
//        return PersonBuilder.this;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;

//        return PersonBuilder.this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalStateException("Возраст должен быть указан от 0 до 150, а у Вас указано  некорректно" + " " + age);
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return PersonBuilder.this;
    }

    public Person build() {
        if ((name == null) || (surname == null)) {
            throw new IllegalStateException("Необходимо заполнить обязательные поля для объекта: имя, фамилия");
        }

        if (age.isPresent()) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        if (!(address == null)) {
            person = new Person(name, surname, age, address);
        }

        return person;
    }
}
