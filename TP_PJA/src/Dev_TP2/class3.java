package Dev_TP2;
import java.util.*;
import java.io.*;

public class class3 {

	public static void main(String[] args) throws IOException {
		
		
		
		// Reading objects from RandomAccessFile
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("employee.dat", "rw");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Employee e = new Employee();
		int numRecords = (int) raf.length() / e.size();
		for (int i = 0; i < numRecords; i++) {
			try {
				e.read(raf);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print(e.name + " ");
			System.out.print(e.address + " ");
			System.out.print(e.number + " ");
		}
		raf.seek(0);
		long current = 0;
		while (current < raf.length()) {

			// read the file
			String result = raf.readUTF();
			System.out.println(result);
			current = raf.getFilePointer();
		}
		
		
		
		
		
		   /*while((obj=objIn.readObject()) instanceof endoffile == false) {
    	  System.out.println(((Employee)obj).name+" "+((Employee)obj).address+" "+((Employee)obj).number);
      }*/
	}

}



