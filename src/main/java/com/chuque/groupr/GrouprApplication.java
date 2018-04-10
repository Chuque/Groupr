package com.chuque.groupr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

//@SpringBootApplication
public class GrouprApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GrouprApplication.class, args);

		ArrayList<Person> personList = new ArrayList<>();
		personList.add(new Person("Rafael", 21));
		personList.add(new Person("Rafael", 15));
		personList.add(new Person("Pedro", 15));

		//use my own method
//		Groupr<Person> groupr = new Groupr(personList,"name");
//		HashMap<String, ArrayList<Person>> groupedMap = groupr.getGroupedMap();

		//use stream




	}
}
