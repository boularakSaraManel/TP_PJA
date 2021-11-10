package Dev_TP2;

import java.io.*;

public class class2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Employee e[]= new Employee[5];
        try {
        ObjectInputStream objIn= new ObjectInputStream(new FileInputStream("serialize.dat"));
        
        
        RandomAccessFile raf = new RandomAccessFile("employees.dat", "rw");
        /*int i=0;
        
        while((e[i]=(Employee) objIn.readObject()) != null ) {//instanceof endoffile == false
           	e[i].write(raf);
           	i++;
        }*/
        
        for(int i=0;i<3;i++) {
        	e[i]=(Employee) objIn.readObject();	
        	e.writeObj(raf);
        }
        	
        	
        
        
        
        objIn.close();
        }catch(IOException i) {
        	i.printStackTrace();
        }
        catch(ClassNotFoundException c)
        {
        	System.out.println("classe Employee non trouvée");
        }
	}

}
