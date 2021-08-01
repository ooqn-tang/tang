import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        System.out.println(Encoders.BASE64.encode("asdfas的开始J啊手动阀手动阀手动阀第三方啊手动阀手动阀FK的dfasdf".getBytes()));

        byte[] keyBytes = Decoders.BASE64.decode(Encoders.BASE64.encode("asdfas的开始J啊手动阀手动阀手动阀第三方啊手动阀手动阀FK的dfasdf".getBytes()));
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Jwts.builder()
                .setSubject("leilei")
                .claim("auth", "fasdfasdfasdfa")
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date())
                .compact();
    }
}
