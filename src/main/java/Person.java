import java.util.OptionalInt;

public class Person {


    private final String name;
    private final String surname;

    private OptionalInt age;

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


    public void happyBirthday() {
        age = OptionalInt.of(age.getAsInt() + 1);
    }

    public boolean hasAge() {
        return age.isPresent();

    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else return true;

    }

    public String getName() {
        return name;
    }


    public OptionalInt getAge() {
        return age;
    }


    public String getAddress() {
        return address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(getAddress());

    }


    @Override
    public String toString() {
        return "Личность{" +
                "Имя= " + name + '\'' +
                ", Фамилия= " + surname + '\'' +
                ", Возраст= " + age.getAsInt() +
                ", Адрес= " + getAddress() +
                '}';
    }
}




