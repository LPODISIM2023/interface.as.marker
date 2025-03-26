package interfaces;

//Java program to illustrate Serializable interface
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//By implementing Serializable interface
//we make sure that state of instances of class A
//can be saved in a file.
class Persona implements Serializable {
	int eta;
	String fullname;
	Indirizzo indirizzo;

	// A class constructor
	public Persona(int eta, String fullname, Indirizzo indirizzo) {
		this.eta = eta;
		this.fullname = fullname;
		this.indirizzo = indirizzo;
	}
}

class Indirizzo implements Serializable {
	String via;

	public Indirizzo(String s) {
		this.via = s;
	}
}

public class SerializeClass {

	private static final String PATH = "example.txt";

	public static void serialize(Persona p) {
		// Serializing 'a'
		try (FileOutputStream fos = new FileOutputStream(PATH);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Persona deserialize(String filename) {
		Persona b = null;
		try (FileInputStream fis = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			b = (Persona) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return b;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona a = new Persona(20, "Juri Di Rocco", new Indirizzo("Esempio"));
		serialize(a);
		Persona b = deserialize(PATH);
		System.out.println(b.eta + " " + b.fullname + " " + b.indirizzo.via);

	}
}