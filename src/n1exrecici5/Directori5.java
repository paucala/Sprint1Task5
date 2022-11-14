package n1exrecici5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directori5 implements Serializable {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(args[0]);
		FilePrinter5 fp = new FilePrinter5();
		Files.walkFileTree(path, fp);
		serializeObject();
		try {
			deserializeObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//metode per crear fitxer .txt
	public static void createTXT (String line) throws IOException {
		File file = new File("Directori.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		bw.close();
		
	}
	// Serialitzem la classe Directori2 en un arxiu.ser
	public static void serializeObject() throws IOException {
		Directori5 directori5 = new Directori5();
		ObjectOutputStream out = new ObjectOutputStream(new	FileOutputStream(new File("Directori.ser"), true));
		out.writeObject(directori5);
		out.close();
	}
	//deserialitzem l'arxiu, aqui podriem imprimir per pantalla els atributs d'una classe o invocar metodes
	public static void deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		Directori5 directori5 = null;
		ObjectInputStream in = new ObjectInputStream (new FileInputStream ("Directori.ser"));
		directori5 = (Directori5)in.readObject();
		in.close();
		System.out.println(directori5);
		
	}
}
