package applicatioin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.FisicalPerson;
import entities.LegalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Person> listOfPeople = new ArrayList<>();

		System.out.print("Enter the number of tax players: ");
		int playerNumber = sc.nextInt();

		for (int i = 1; i <= playerNumber; i++) {
			System.out.println("Tax payer #" + i + " data");

			System.out.print("Individual or company (i/c)? ");
			char response = sc.next().charAt(0);

			while (response != 'i' && response != 'c') {
				System.out.print("Enter with value valid: ");
				response = sc.next().charAt(0);
			}

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Anual income: ");
			Double annualIncome = sc.nextDouble();

			if (response == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenses = sc.nextDouble();
				listOfPeople.add(new FisicalPerson(name, annualIncome, healthExpenses));
			} else {
				System.out.print("Number of employees: ");
				Integer employeeNumber = sc.nextInt();
				listOfPeople.add(new LegalPerson(name, annualIncome, employeeNumber));
			}
		}
		
		System.out.println("\nTAXES: ");
		
		for (Person person : listOfPeople) {
			System.out.println(person.getName() + ": $ " + String.format("%.2f", person.tax()));
		}
		
		double sum = 0.0;
		for (Person person : listOfPeople) {
			sum += person.tax();
		}
		
		System.out.printf("\nTOTAL TAXES: $ %.2f", sum);
		
		sc.close();
	}

}
