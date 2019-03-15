package com.rtmap.middle.framework.mvc.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.rtmap.middle.framework.annotation.JWTAuth;
import com.rtmap.middle.framework.annotation.NoAuth;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.annotation.JWTAuth;
import com.rtmap.middle.framework.annotation.NoAuth;
import com.rtmap.middle.framework.base.Context;
import com.rtmap.middle.framework.consts.CodeMsg;
import com.rtmap.middle.framework.model.Result;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        try {
            response.setCharacterEncoding("utf-8");
            if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
                PrintWriter out = response.getWriter();
                out.print(true);
                out.flush();
                out.close();
                return false;
            }

            // 如果不是映射到方法直接通过
            if (!(object instanceof HandlerMethod)) {
                return true;
            }

            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();

            //检查是否有passtoken注释，有则跳过认证
            NoAuth passToken = method.getAnnotation(NoAuth.class);
            if (passToken != null && passToken.required()) {
                return true;
            }
            //获取jwtAuth注解
            JWTAuth jwtAuth = method.getAnnotation(JWTAuth.class);
            if (jwtAuth == null) {
                jwtAuth = handlerMethod.getBeanType().getAnnotation(JWTAuth.class);
            }

            //非jwtAuth注解获取未启用跳过认证
            if (jwtAuth == null || !jwtAuth.required()) {
                return true;
            }

            //从header获取token
            String token = request.getHeader("token");
            if (token == null) {
                //return errMsg(CodeMsg.INVALID_USER, response);
            }

            // 获取token中的userid
            //String userId = JWT.decode(token).getAudience().get(0);
            //StaffVO query = new StaffVO();
            //query.setId(userId);
            //StaffVO user = staff.get(query).getData();
            //if (user == null)
            //   return errMsg(CodeMsg.INVALID_USER, response);

            //验证token
            //JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getSalt() + user.getPwd())).build();
            //jwtVerifier.verify(token);

            //设置上线文
            //Context.setLocalContext(user.getTeam(), user.getRole(), user.getId());

            return true;

        } catch (JWTDecodeException e) {
            return errMsg(CodeMsg.INVALID_TOKEN, response);
        } catch (JWTVerificationException e) {
            return errMsg(CodeMsg.INVALID_TOKEN, response);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        Context.removeLocalContext();
    }

    private boolean errMsg(int code, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(JSONObject.toJSONString(Result.error(code)));
        out.flush();
        out.close();
        return false;
    }
}