package Dev_TP2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class class1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serializeObjects(readEmployeesInfos());
		deserializeObjects();
	}

	// Retrieve employess infos from user interface
	public static Employee[] readEmployeesInfos() {
		// Read the number of employees
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of employees");
		int numberOfEmployees = input.nextInt();
		input.nextLine();

		// Decalar array of employee Object
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
			objOut = new ObjectOutputStream(new FileOutputStream("serialize.dat"));
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

	// Deserialize a file of objects
	public static void deserializeObjects() {
		// Employee employees[] = null;
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream("serialize.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Object obj = null;
			while ((obj = in.readObject()) instanceof endoffile == false) {
				employees.add((Employee) obj);
			}
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("classe Employee non trouvee");
			c.printStackTrace();
			return;
		}

		for (Employee e : employees) {
			System.out.println("Employee deserialise...");
			System.out.println("Nom: " + e.name);
			System.out.println("Adresse: " + e.address);
			System.out.println("Number: " + e.number);
		}
	}
}

class endoffile implements Serializable {

}