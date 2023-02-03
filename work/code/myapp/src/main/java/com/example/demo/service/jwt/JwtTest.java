package com.example.demo.service.jwt;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.util.Date;

/**
 * @author gaonan1
 * @date 2020/5/13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {

    @Test
    public void testJwt() {
        Date exp = Date.from(Instant.ofEpochMilli(System.currentTimeMillis() + 100000));
        String encodedKey = "abcdefg";
        byte[] decodedKey = BaseEncoding.base64().decode(encodedKey);
        SecretKey key = new SecretKeySpec(decodedKey, "AES");
        String token = Jwts.builder()
                .claim("user_id", 1)
                .claim("username", "jack")
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
        System.out.println("这个是加密出来的token: {}" + token);

        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("不能相信签名: {}" + e);
            claims = null;
        }
        System.out.println("这个是解密出来的claims: {}" + claims);
    }
}
