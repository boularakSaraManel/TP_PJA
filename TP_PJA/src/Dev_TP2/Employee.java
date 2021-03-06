package Dev_TP2;

import java.io.*;

@SuppressWarnings("serial") // ?? idk what this does
public class Employee implements Serializable {
	public String name;
	public String address;
	public transient int SSN;
	public String number;

	public Employee(String name, String address, String number) {

		this.name = name;
		this.address = address;
		this.number = number;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void mailCheck() {
		System.out.println("Mail de verification de " + name + " " + address);
	}

	void writeObj(RandomAccessFile raf) throws IOException {
		StringBuffer sb;
		if (name != null)
			sb = new StringBuffer(name);
		else
			sb = new StringBuffer();

		sb.setLength(15);
		raf.writeChars(sb.toString());

		if (address != null)
			sb = new StringBuffer(address);
		else
			sb = new StringBuffer();

		sb.setLength(15);
		raf.writeChars(sb.toString());

		if (number != null)
			sb = new StringBuffer(number);
		else
			sb = new StringBuffer();

		sb.setLength(30);
		raf.writeChars(sb.toString());

	}

	void read(RandomAccessFile raf) throws IOException {
		char[] temp = new char[15];

		for (int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		name = new String(temp);
		temp = new char[15];
		for (int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		address = new String(temp);
		temp = new char[30];
		for (int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		number = new String(temp);
	}

	int size() {
		return 2 * (15 + 15 + 30);
	}
}