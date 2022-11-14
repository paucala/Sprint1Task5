package n1exercici2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class FilePrinter2 extends SimpleFileVisitor<Path>{
	ArrayList<File> files;
	long lastMod = 0;

	//amb aquest mètode imprimeixo el nom del directori on anem a entrar, 
	//no he sapigut fer-ho per tal que si hi ha algun arxiu en el mateix directori s'imprimeixi abans
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {

		files = new ArrayList<File>();
		lastMod = dir.toFile().lastModified();
		Date date = new Date(lastMod);
		if (dir.toFile().isDirectory()) {
			System.out.println("D: " + dir + " Última modificació: " + date);
		} else {
			System.out.println("F: " + dir + " Última modificació: " + date);
		}
				
		
		return FileVisitResult.CONTINUE;
	}

	//afegim tots els arxius a un ArrayList que es sobreescriu a cada nou directori
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		files.add(file.toFile());
		return FileVisitResult.CONTINUE;
	}

	// checkeig d'excepcions
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc){
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}

	//ordenem i imprimin els arxius dins de cada directori, reiniciem l'arraylist
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		Collections.sort(files);
		for (File file : files) {
			lastMod = file.lastModified();
			Date date = new Date(lastMod);
			System.out.println("F: " + file + " Última modificació: " + date);
		}
		files = new ArrayList<File>();
		return FileVisitResult.CONTINUE;
	}
	

}
