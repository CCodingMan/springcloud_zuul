package com.ljj.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: ljj
 * @Date: 2019/8/20 21:53
 * @Description:
 */
@Component
public class MyFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        // pre：路由之前，routing：路由之时，post： 路由之后，error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() { // 过滤顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() { // 这里可以写逻辑判断，是否要过滤，本文true,永远过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info(String.format("%s >> %s", request.getMethod(), request.getRequestURL().toString()));
        Object token = request.getParameter("token");
        if(token == null){
            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
