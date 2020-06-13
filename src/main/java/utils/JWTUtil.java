package utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;

public class JWTUtil {

    private static final String chave = "FORUM_SECRET_KEY";

    public static String criarToken(String login)
            throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
        return JWT.create().withSubject(login).sign(Algorithm.HMAC512(chave));
    }

    public static Map<String, Claim> decodificarToken(String token) {
         Map<String, Claim> claims = JWT.decode(token).getClaims();
         return claims;
    }
}