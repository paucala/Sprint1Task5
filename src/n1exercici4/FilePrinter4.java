package n1exercici4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;

public class FilePrinter4 extends SimpleFileVisitor<Path> {
	ArrayList<File> files;
	long lastMod = 0;
	

	//amb aquest mètode guardo el nom del directori en un arxiu.txt, 
	//no he sapigut fer-ho per tal que si hi ha algun arxiu en el mateix directori s'imprimeixi abans
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		files = new ArrayList<File>();
		lastMod = dir.toFile().lastModified();
		Date date = new Date(lastMod);
		Directori4.createTXT("D: " + dir + " Última modificació: " + date + "\n");
		
		return FileVisitResult.CONTINUE;
	}

	//afegim tots els arxius a un ArrayList que es sobreescriu a cada nou directori
	// si un arxiu es .txt s'imprimira per pantalla el contingut
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {
		files.add(file.toFile());
		if (FilenameUtils.isExtension(file.toFile().getAbsolutePath(), "txt")) {
			BufferedReader br = new BufferedReader( new FileReader(file.toFile()));
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		}
		return FileVisitResult.CONTINUE;
	}
	// checkeig d'excepcions
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}

	//guardem al txt totes les entrades, reiniciem l'arraylist
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		Collections.sort(files);
		for (File file : files) {
			lastMod = file.lastModified();
			Date date = new Date(lastMod);
			Directori4.createTXT("F: " + file + " Última modificació: " + date + "\n");
		}
		files = new ArrayList<File>();
		return FileVisitResult.CONTINUE;
	}

}
