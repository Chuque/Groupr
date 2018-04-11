package com.chuque.groupr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootApplication
public class GrouprApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GrouprApplication.class, args);

		//declara a lista
		ArrayList<Person> personList = new ArrayList<>();
		personList.add(new Person("Rafael", 21));
		personList.add(new Person("Rafael", 15));
		personList.add(new Person("Pedro", 18));
		personList.add(new Person("Pedro", 21));

		//show unordered list
		System.out.println("Desordenada:");
		for(Person person : personList){
			System.out.println(person.toString());
		}
		System.out.println();

		//use Groupr to ordenate
		Groupr<Person> groupr = new Groupr(personList,"name");
		HashMap<Object, ArrayList<Person>> groupedMap = groupr.getGroupedMap();

		//show ordered list
		System.out.println("Agrupada:");
		for (Map.Entry<Object, ArrayList<Person>> entry : groupedMap.entrySet()){
			System.out.println("Chave: " + entry.getKey());
			for (Person person : entry.getValue()){
				System.out.println(person.toString());
			}
			System.out.println();
		}
	}
}
