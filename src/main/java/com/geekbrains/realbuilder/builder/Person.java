package com.geekbrains.realbuilder.builder;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private String gender;
    private int age;

    public Person(PersonBuilder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Please provide the data to create the Person object");
        }
        if (builder.firstName == null || builder.firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide Persons firstName.");
        }
        if (builder.lastName == null || builder.lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide Persons lastName.");
        }
        if (builder.middleName == null || builder.middleName.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide Persons middleName.");
        }
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.country = builder.country;
        this.address = builder.address;
        this.phone = builder.phone;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString( ) {
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("FCs: ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append(", ")
               .append("Age: ").append(age).append(", ")
               .append("Gender: ").append(gender).append(", ")
               .append("Contacts: ").append(country).append(", ").append(address).append(", ").append(phone).append(".");
                return stringBuilder.toString();
    }

    // вложенный класс
    public static class PersonBuilder {
        protected String firstName;
        protected String lastName;
        protected String middleName;
        protected String country;
        protected String address;
        protected String phone;
        protected String gender;
        protected int age;

        public PersonBuilder() {
            super();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder country(String country) {
            this.country = country;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Person build() {
            Person person = null;
            if (validatePerson()) {
                person = new Person(this);
            } else {
                System.out.println("Sorry! Person objects can't be build without required details");
            }
            return person;
        }
        // обязательные параметры ФИО
        private boolean validatePerson() {
            return (firstName != null && lastName != null && middleName != null
                    && !firstName.trim().isEmpty() && !lastName.trim().isEmpty() && !middleName.trim().isEmpty());
        }
    }
}
