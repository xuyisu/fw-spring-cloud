package com.yisu.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yisu.base.dao.model.SysUser;
import org.springframework.stereotype.Component;

/**
 * Jwt生成token 工具类
 *
 * @author xuyisu
 * @date 2020-03-22
 */
@Component
public class JwtTokenUtil {
    /**
     * 根据用户信息生成token
     * @param sysUser
     * @return
     */
    public String getToken(SysUser sysUser) {
        String token="";
        token= JWT.create().withAudience(sysUser.getId().toString())// id 保存到 token 里面
                .sign(Algorithm.HMAC256(sysUser.getPassword()));// password 作为 token 的密钥
        return token;
    }
}
