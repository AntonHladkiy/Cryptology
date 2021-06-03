import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.Assert.*;

class SignatureTest {
    static String pathSign = "Sign.txt";
    static String pathPublicKey = "PublicKey.txt";
    static String pathPrivateKey = "PrivateKey.txt";
    static String pathFragment = "Fragment.txt";
    static String pathAnotherPublicKey = "PublicKeyAlter.txt";
    static String pathAnotherPrivateKey = "PrivateKeyAlter.txt";
    @Test
    void encryptionAndDecryption() throws IOException, NoSuchAlgorithmException {
        PrintWriter writer1 = new PrintWriter(pathAnotherPublicKey);
        writer1.print("");
        writer1.close();
        PrintWriter writer2 = new PrintWriter(pathAnotherPrivateKey);
        writer2.print("");
        writer2.close();
        Signature.generate( 1000,pathAnotherPublicKey,pathAnotherPrivateKey );
        // Encoded data with different keys is different
        Signature.makeSign(pathFragment, pathPublicKey, pathPrivateKey, pathSign);
        assertTrue(Signature.checkSign(pathFragment, pathPublicKey, pathSign));

        // Swap keys
        assertFalse(Signature.checkSign(pathFragment, pathAnotherPublicKey, pathSign));
    }
}
