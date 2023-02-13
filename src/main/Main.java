package main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> people = getPeople();
		
		//Filter
		System.out.println("\n********* Filtering and printing all Males **************\n");
		people.stream()
			.filter(person-> person.gender.equals(Gender.MALE))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Sort (based on age)
		System.out.println("\n********* Sorting based on age and printing **************\n");
		people.stream()
			.sorted(Comparator.comparing(Person::getAge).reversed())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//All Match
		System.out.println("\n********* Asking if the ages of people are > 5 **************\n");
		boolean allMatch = people.stream()
									.allMatch(person ->person.getAge() > 5);
		System.out.println(allMatch);
		
		//Any Match
		System.out.println("\n********* Asking if the age of at least one person is > 100 **************\n");
		boolean anyMatch = people.stream()
									.anyMatch(person ->person.getAge() > 100);
		System.out.println(anyMatch);
			
		//None Match
		System.out.println("\n********* Asking if nobody's name equals (****) **************\n");
		boolean noneMatch = people.stream()
									.noneMatch(person ->person.getName().equals("Person 10"));
		System.out.println(noneMatch);
		
		//MAX
		System.out.println("\n********* Asking for the oldest person **************\n");
		people.stream()
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println);
		
		//MIN
		System.out.println("\n********* Asking for the youngest person **************\n");
		people.stream()
				.min(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println);
		
		//GROUP
		System.out.println("\n********* Grouping Based on Gender **************\n");
		people.stream()
				.collect(Collectors.groupingBy(Person::getGender))
				.forEach((gender, persons) -> {
					System.out.println(gender);
					persons.forEach(System.out::println);
					System.out.println();
				});
		
		System.out.println("\n********* Getting the oldest female **************\n");
		people.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE))
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println);
	}
	
	
	private static List<Person> getPeople () {
		return List.of(
				new Person("Person 1", 25, Gender.MALE),
				new Person("Person 2", 17, Gender.FEMALE),
				new Person("Person 3", 34, Gender.MALE),
				new Person("Person 4", 26, Gender.FEMALE),
				new Person("Person 5", 54, Gender.MALE),
				new Person("Person 6", 42, Gender.FEMALE),
				new Person("Person 7", 150, Gender.MALE),
				new Person("Person 8", 33, Gender.FEMALE),
				new Person("Person 9", 64, Gender.MALE)
				);
	}
}
