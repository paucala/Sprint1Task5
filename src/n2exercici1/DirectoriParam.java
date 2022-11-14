package n2exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DirectoriParam {

	public static void main(String[] args) throws IOException {
		String arg1 = args[0];
		String arg2 = args[1];
		createPropertieFile(arg1, arg2);
		Path path = Paths.get(readPropertieFile("path"));
		FilePrinterParam fp = new FilePrinterParam();
		Files.walkFileTree(path, fp);
		System.out.println("arxiu creat a la carpeta:" + readPropertieFile("fileDirectory"));

	}
	//metode per crear fitxer .txt
	public static void createTXT (String line) throws IOException {
		File file = new File(readPropertieFile("fileName"));
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		bw.close();
		
	}
	//creem un arxiu de configuració amb els noms entrats des de la consola
	public static void createPropertieFile(String arg1, String arg2) throws IOException {
		OutputStream output = new FileOutputStream("directori.properties");
		Properties prop = new Properties();
		prop.setProperty("path", arg1);
		prop.setProperty("fileName", arg2);
		prop.setProperty("fileDirectory", arg1);
		prop.store(output, null);
	}
	//llegim l'arxiu de configuració
	public static String readPropertieFile(String str) throws IOException {
		InputStream input = new FileInputStream("directori.properties");
        Properties prop = new Properties();
        prop.load(input);
        String str2 = "";
        if (str.equals("path")) {
        	str2 = prop.getProperty(str);
        } else if (str.equals("fileName")) {
        	str2 = prop.getProperty(str);
        } else {
        	str2 = prop.getProperty(str);
        }
        return str2;
	}
}
