package kr.dev;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * How to hash some string with sha256 in Java?
 * <a>https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java</a>
 */

public class Example {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plain = "HelloWorld";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(plain.getBytes(StandardCharsets.UTF_8));
        System.out.println("plain: " + plain);
        System.out.println("hashed: " + encodeToString(hashed));
        System.out.println("hashed(using Guava): " + Hashing.sha256().hashBytes(plain.getBytes(StandardCharsets.UTF_8)));
        System.out.println("hashed(using Codec): " + DigestUtils.sha256Hex(plain.getBytes(StandardCharsets.UTF_8)));
    }

    private static String encodeToString(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
