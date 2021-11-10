package Dev_TP2;
import java.util.*;
import java.io.*;

public class class3 {

	public static void main(String[] args) {
		
		Employee e[]=null;
		Object obj= null;
		Scanner input= new Scanner(System.in);
		System.out.println("entrer le numero de l'objet que vous voulez afficher :");
		int number= input.nextInt();
         
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("serialize.dat"));
			while((obj=objIn.readObject()) instanceof endoffile == false) {
		      	  System.out.println(((Employee)obj).name+" "+((Employee)obj).address+" "+((Employee)obj).number);
		        }
			objIn.close();
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Classe Employee non trouvée");
			c.printStackTrace();
			return;
		}
		
		
		
		   /*while((obj=objIn.readObject()) instanceof endoffile == false) {
    	  System.out.println(((Employee)obj).name+" "+((Employee)obj).address+" "+((Employee)obj).number);
      }*/
	}

}



