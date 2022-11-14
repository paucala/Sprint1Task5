package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class Directori {

	public static void main(String[] args) {
		File folder = new File (args[0]);
		sortFilesinFolder(folder);
		

	}
	public static void sortFilesinFolder (File folder) {
	// no se si amb un array normal hi hauria prou o si es millor fer l'arraylist
	//ArrayList<File> sortedFiles = new ArrayList<File>(Arrays.asList(folder.listFiles()));
	File[] sortedFiles = folder.listFiles();
	//si fes un arrayList seria Collections.sort
	Arrays.sort(sortedFiles);
	for (File file : sortedFiles) {
		System.out.println(file);
	}
	
	}

}
