package org.backend.contentgenerator.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private String secretKey ="";
    public JWTService(){
        KeyGenerator key = null;
        try {
            key = KeyGenerator.getInstance("HmacSHA256");
            SecretKey s = key.generateKey();
            secretKey = Base64.getEncoder().encodeToString(s.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

        public String generateToken(String username){
//        Map<String, Object> cl= new HashMap<>();

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*30))
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] data = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(data);
    }
}
