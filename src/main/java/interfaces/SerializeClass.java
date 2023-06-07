package interfaces;

//Java program to illustrate Serializable interface
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//By implementing Serializable interface
//we make sure that state of instances of class A
//can be saved in a file.
class MyClass implements Serializable{
	int i;
	String s;
	MyRelatedClass rc;

	// A class constructor
	public MyClass(int i, String s, MyRelatedClass rc) {
		this.i = i;
		this.s = s;
		this.rc = rc;
	}
}

class MyRelatedClass implements Serializable{
	String s;

	public MyRelatedClass(String s) {
		this.s = s;
	}
}

public class SerializeClass {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		MyClass a = new MyClass(20, "GeeksForGeeks", new MyRelatedClass("Juri"));

		// Serializing 'a'
		FileOutputStream fos = new FileOutputStream("xyz.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);

		// De-serializing 'a'
		FileInputStream fis = new FileInputStream("xyz.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		MyClass b = (MyClass) ois.readObject();// down-casting object

		System.out.println(b.i + " " + b.s + " " + b.rc.s);

		// closing streams
		ois.close();
	}
}