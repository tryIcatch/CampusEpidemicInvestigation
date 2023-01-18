package com.trycatch.camepiinvspringboot.utils;

import com.trycatch.camepiinvspringboot.key.Constant;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.bouncycastle.util.encoders.Base64;
import org.joda.time.DateTime;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;



public class JwtUtil {
    public static SecretKey getsecretKey(){
        byte[] encodekey = Base64.decode(Constant.JWT_SECRET);
        SecretKey key = new SecretKeySpec(encodekey, 0, encodekey.length, "AES");
        return key;
    }
    public static String createJWT(final String subject, final Long expireMills){


        Date now=DateTime.now().toDate();

        //定义签名算法
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        //定义生成密钥
        SecretKey key =getsecretKey();
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setIssuer("trycatch")
                .signWith(algorithm,key);

        if(expireMills>=0){
            long realExpire = System.currentTimeMillis() + expireMills;
            builder.setExpiration(new Date(realExpire));
        }

      return   builder.compact();
    }


}
