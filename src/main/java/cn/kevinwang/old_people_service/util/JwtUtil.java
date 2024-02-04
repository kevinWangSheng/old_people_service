package cn.kevinwang.old_people_service.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import static java.security.KeyRep.Type.SECRET;

/**
 * @author wang
 * @create 2024-01-30-12:27
 */
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    private static final String secret = "wanglaowu";
    public static final String HEADER = "Authorization";

    public static final long expireTime = 60*24*7;
    public static String createJwtToken(String username,long expireTime){
        SecretKey signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        LocalDateTime tokenExpirationTime = LocalDateTime.now().plusSeconds(expireTime);
        return Jwts.builder()
                .signWith(signingKey, Jwts.SIG.HS512)
                .header().add("typ", "JWT").and()
                .issuedAt(Timestamp.valueOf(LocalDateTime.now()))
                .subject(username)
                .expiration(Timestamp.valueOf(tokenExpirationTime))
                .claims(Map.of("username", username))
                .compact();
    }

    public static Claims getClaimsByToken(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser().verifyWith(secretKey).build().parseClaimsJws(token).getPayload();
    }

    public static boolean isExpire(String token){
        return getClaimsByToken(token).getExpiration().before(new Date());
    }

    public static String getClaimFiled(String token, String filed){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(filed).asString();
        } catch (JWTDecodeException e){
            log.error("JwtUtil getClaimFiled error: ", e);
            return null;
        }
    }

    public static String createToken(String username){
        return createJwtToken(username,1000*60*60*24);
    }

    public static boolean verify(String token){
        try {
            Jwts.parser().setSigningKey(secret).build().parseSignedClaims(token).getBody();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
