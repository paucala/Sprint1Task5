package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directori3 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(args[0]);
		FilePrinter3 fp = new FilePrinter3();
		Files.walkFileTree(path, fp);

	}
	//metode per crear fitxer .txt
	public static void createTXT (String line) throws IOException {
		File file = new File("Directori.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		bw.close();
		
	}		
}
