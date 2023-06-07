package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main (String[] args) {
		System.out.println(System.getProperty("user.dir"));
//		Properties pops = System.getProperties();

		//GESTIONE FILE 
		try (FileInputStream fis = new 
				FileInputStream("application.properties")){
			Properties props = new Properties();
			props.load(fis);
			if (props.containsKey("esempio.nome")) {
				System.out.println(props.getProperty("esempio.nome"));
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
//		
//		//GESTIONE DIVERSA DEI FILE
		try (InputStream input = PropertiesTest.class.getClassLoader().
				getResourceAsStream("application.properties")){
			Properties props = new Properties();
			props.load(input);
			if (props.containsKey("esempio.cognome")) {
				System.out.println(props.getProperty("esempio.cognome"));
			}
		} catch (IOException e) {
            System.err.println(e.getMessage());
        }
//		Integer x = 1000;
//		Integer y = 1000;
//		System.out.println(x==y); 
	}

}
