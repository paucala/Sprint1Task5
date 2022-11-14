package n3exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptandDecryptFile {
	
	private SecretKey secretKey;
	private IvParameterSpec parameterSpec;
	
	public EncryptandDecryptFile () throws NoSuchAlgorithmException {
		this.secretKey = generateKey();
		this.parameterSpec = genearteIVParameterSpec();
	}
	
	public SecretKey generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    SecretKey secretKey = keyGenerator.generateKey();
	    return secretKey;
	}
	public IvParameterSpec genearteIVParameterSpec() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		byte[] InitVectorBytes = keyGenerator.generateKey().getEncoded();
		IvParameterSpec parameterSpec = new IvParameterSpec(InitVectorBytes);
		return parameterSpec;
	}
	public void encryptFile (File file, File fileEncrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, 
															InvalidKeyException, InvalidAlgorithmParameterException, 
															IllegalBlockSizeException, BadPaddingException, IOException {
		
		Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		encryptionCipher.init(Cipher.ENCRYPT_MODE,this.secretKey,this.parameterSpec);
		FileInputStream inputStream = new FileInputStream(file);
		FileOutputStream outputStream = new FileOutputStream(fileEncrypted);
		byte[] buffer = new byte[(int)file.length()];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = encryptionCipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte [] outputBytes = encryptionCipher.doFinal();
		if (outputBytes != null) {
			outputStream.write(outputBytes);
		}
		inputStream.close();
		outputStream.close();
		}
	public void decryptFile (File file, File fileEncrypted) throws IOException, 
											IllegalBlockSizeException, BadPaddingException, InvalidKeyException, 
											InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException {
		Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptionCipher.init(Cipher.DECRYPT_MODE,this.secretKey,this.parameterSpec);
        FileInputStream inputStream = new FileInputStream(fileEncrypted);
		FileOutputStream outputStream = new FileOutputStream(file);
		byte[] buffer = new byte[(int)fileEncrypted.length()];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = decryptionCipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte [] outputBytes = decryptionCipher.doFinal();
		if (outputBytes != null) {
			outputStream.write(outputBytes);
		}
		inputStream.close();
		outputStream.close();
		}
	}
	


