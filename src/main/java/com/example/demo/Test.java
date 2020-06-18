package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("r1", 25);
		Person p2 = new Person("r2", 50);
		Person p3 = new Person("r3", 40);
		List<Person> list = new ArrayList<>(); list.add(p1);list.add(p2);list.add(p3);
		
		Stream<Person> stream = list.stream();
		System.out.println(stream.map(p -> p.getAge()).filter(i -> i > 30).reduce(0, Integer::sum));
			
	}
	
	static class Person {
		
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		String name;
		int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}

}
