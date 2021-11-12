package Dev_TP2;

import java.io.*;
import java.util.ArrayList;

public class class2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees = new ArrayList<>();
			try {
				employees = deserializeObjects();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		// Writing deserialized employee objects into RandomAccessFile
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("empdirect.dat", "rw");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Employee e : employees) {
			try {
				e.writeObj(raf);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	
		
	}
	
	// Deserialize a file of objects
		public static ArrayList<Employee> deserializeObjects() throws IOException, ClassNotFoundException {
			// Employee employees[] = null;
			ArrayList<Employee> employees = new ArrayList<>();

			FileInputStream fileIn = new FileInputStream("emp.dat");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			Object obj = null;
			while ((obj = objIn.readObject()) instanceof endoffile == false) {
				employees.add((Employee) obj);
			}
			objIn.close();
			fileIn.close();

			for (Employee e : employees) {
				System.out.println("Employee deserialise...");
				System.out.println("Nom: " + e.name);
				System.out.println("Adresse: " + e.address);
				System.out.println("Number: " + e.number);
			}
			return employees;
		}
}
