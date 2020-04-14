package com.jamel.adminpage.interceptor;

import cn.hutool.json.JSON;
import com.jamel.adminpage.pojo.User;
import com.jamel.adminpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            String method = ((HandlerMethod) handler).getMethod().getName();
            if ("login.html".equals(method)) {
                return true;
            }else if ("login".equals(method)) {
                return true;
            }
            User user = getUser(request, response);
            if(user == null){
                //未登录
                render(response);
                return false;
            }
        }
        return true;
    }

    private User getUser(HttpServletRequest request, HttpServletResponse response) {
        //根据系统不同，系统用来管理session的方式也不相同，所以此处获取user信息的方法就不具体展开实现了
        //本人是采用token+redis存储的方式来实现管理的，所以此处是通过token去redis中getUser即可
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    private void render(HttpServletResponse response)throws Exception {
//        response.setContentType("application/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = "<script>location.href='login.html';</script>";
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}

