package n3exercici1;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DirectoriEncrypt {	
	

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, 
											NoSuchPaddingException, InvalidAlgorithmParameterException, 
											IllegalBlockSizeException, BadPaddingException, IOException{
		EncryptandDecryptFile encryptFile = new EncryptandDecryptFile();
		encryptFile(encryptFile, new File(args[0]));
		decryptFile(encryptFile, new File(args[1]));

	}
	public static String changeFileName(File file, int Mod) {
		String encryptedFileName = file.toString();
		String[] parts = encryptedFileName.split("\\.");
		String part1 = "";
		if (Mod == 1) {
			part1 = parts[0].concat("encrypted.");
		} else {
			part1 = parts[0].concat("decrypted.");
		}
		String part2 = parts[1];
		String fileName = part1.concat(part2);
		return fileName;
	}
	public static void encryptFile(EncryptandDecryptFile encryptFile, File file) throws InvalidKeyException, NoSuchAlgorithmException, 
												NoSuchPaddingException, InvalidAlgorithmParameterException, 
												IllegalBlockSizeException, BadPaddingException, IOException {
		String encryptedFileName = changeFileName(file, 1);
		File fileEncrypted = new File(encryptedFileName);
		encryptFile.encryptFile(file, fileEncrypted);
		System.out.println("Arxiu encriptat");
	}
	public static void decryptFile (EncryptandDecryptFile encryptFile, File file) throws InvalidKeyException, IllegalBlockSizeException, 
													BadPaddingException, InvalidAlgorithmParameterException, 
													NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		String decryptedFileName = changeFileName(file, 2);
		File fileDecrypted = new File(decryptedFileName);
		encryptFile.decryptFile(fileDecrypted, file);
		System.out.println("Arxiu desencriptat");
	}
}
