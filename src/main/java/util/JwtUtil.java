package util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * 生成 JWT
     * @param claims   payload 数据（可传 JSON 转换成 Map）
     * @param secret   签名密钥
     * @param ttlMillis 有效期（毫秒），可为 null 或 0 表示不过期
     */
    public static String generateJwt(Map<String, Object> claims, String secret, Long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret);

        if (ttlMillis != null && ttlMillis > 0) {
            builder.setExpiration(new Date(nowMillis + ttlMillis));
        }

        return builder.compact();
    }

    /**
     * 解析并验证 JWT
     * @param token  JWT 字符串
     * @param secret 密钥
     * @return payload 数据
     */
    public static Claims parseJwt(String token, String secret) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
