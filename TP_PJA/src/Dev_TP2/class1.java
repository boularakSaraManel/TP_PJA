package Dev_TP2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class class1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serializeObjects(readEmployeesInfos());


	}

	// Retrieve employess infos from user input interface
	public static Employee[] readEmployeesInfos() {
		// Read the number of employees
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of employees");
		int numberOfEmployees = input.nextInt();
		input.nextLine();

		// Decalare array of employee Object
		Employee employees[] = null;

		if (numberOfEmployees > 0) {
			employees = new Employee[numberOfEmployees];
			System.out.println("Enter the employees infos :");
			String name, address, number;

			// Read employees infos one by one
			for (int i = 0; i < employees.length; i++) {
				System.out.println("Enter the emplyee " + (i + 1) + " name");
				name = input.nextLine();
				System.out.println("Enter the emplyee " + (i + 1) + " adress");
				address = input.nextLine();
				System.out.println("Enter the emplyee " + (i + 1) + " number");
				number = input.nextLine();
				employees[i] = new Employee(name, address, number);
			}
			input.close();
		} else {
			System.out.println("Invalid number of employees");
		}
		return employees;
	}

	// Serialize an array of objects
	public static void serializeObjects(Object[] objects) {
		ObjectOutputStream objOut = null;
		try {
			objOut = new ObjectOutputStream(new FileOutputStream("emp.dat"));
			for (Object o : objects) {
				objOut.writeObject(o);
			}
			objOut.writeObject(new endoffile());
			objOut.close();
			System.out.print("donnees serialisees sauvegardees");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	
}

 class endoffile implements Serializable {

}



