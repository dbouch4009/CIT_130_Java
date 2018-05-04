import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class main
{
    public static void main(String[] args)
    {
        System.out.println("Hello");

        byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
        byte[] plainText = "Helloooooooo world!".getBytes(StandardCharsets.UTF_8);
        AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(
                encryptionKey);
        byte[] cipherText = advancedEncryptionStandard.encrypt(plainText);
        byte[] decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);

        System.out.println(new String(plainText));
        System.out.println(new String(cipherText));
        System.out.println(new String(decryptedCipherText));


    }
}

