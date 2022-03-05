import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class Test {

    private long time = 1000 * 3600 * 24;

    private String signature = "Hello";

    @org.junit.Test
    public void generate(){
        JwtBuilder builder = Jwts.builder();
        String token = builder
                //header
                .setHeaderParam("type", "JWT")
                .setHeaderParam("alg", "HS256")
                //payLoad
                .claim("uName", "tom")
                .claim("role", "admin")
                .setSubject("adminTest")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact()
                ;
        return;
    }

    @org.junit.Test
    public void parse(){
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ1TmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluVGVzdCIsImV4cCI6MTY0NjU3Mjg0MCwianRpIjoiYzk2MmFiOWYtYzU5NS00ZDJjLThhYmItODJiNTYzNWU0NjhiIn0.vf3oK-q_Y5MkIqF0aY6icjHfiJxGy5IfEWy1vbrb674";
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser
                                    .setSigningKey(signature)
                                    .parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return;
    }
}
