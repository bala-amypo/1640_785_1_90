// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// @Component
// public class JwtUtil {
//     private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     private final long expiration = 86400000; // 24 hours

//     public String generateToken(String userId, String email, String role) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", email);
//         claims.put("role", role);
//         return createToken(claims, userId);
//     }

//     private String createToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .claims(claims)
//                 .subject(subject)
//                 .issuedAt(new Date(System.currentTimeMillis()))
//                 .expiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(secretKey)
//                 .compact();
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "demo-secret-key-1234567890-very-long-for-security";
    private static final long EXPIRATION_MS = 24 * 60 * 60 * 1000; // 24 hours

    // ✅ FIXED: Now accepts String userId (convert Long to String)
    public static String generateToken(String email, Long userId) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId.toString())  // ✅ Convert Long to String
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }
}
