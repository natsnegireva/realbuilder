package com.geekbrains.realbuilder.builder;

public class PersonApplication {

	public static void main(String[] args) {

		Person person = new Person.PersonBuilder()
				.firstName("Nikolay").middleName("Vasilievich").lastName("Sedov").build();

		Person person1 = new Person.PersonBuilder()
				.firstName("Maxim").middleName("Ivanovich").lastName("Gogol").age(45).gender("man").build();

		System.out.println(person);
		System.out.println(person1);
	}
}
