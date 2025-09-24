package view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

public class JwtPanel extends AbstractCryptoPanel {

    @Override
    protected String encrypt(String input, String key) {
        try {
            // 把输入的 JSON 字符串转为 Map
            Map<String, Object> claims = JSON.parseObject(input, Map.class);
            // 生成 JWT（不过期，可自行扩展为支持 TTL 输入）
            return JwtUtil.generateJwt(claims, key, null);
        } catch (Exception e) {
            return "JWT 生成失败：" + e.getMessage();
        }
    }

    @Override
    protected String decrypt(String input, String key) {
        try {
            Claims claims = JwtUtil.parseJwt(input, key);
            // 把 Claims 转换为 JSON 字符串，格式化输出
            JSONObject json = new JSONObject(claims);
            return JSON.toJSONString(json, true); // true 表示格式化缩进
        } catch (Exception e) {
            return "JWT 解析失败：" + e.getMessage();
        }
    }
}
