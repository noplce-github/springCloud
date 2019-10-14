package com.mengxuegu.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: 梦学谷
 */
@Component //一定不要少了
public class LoginFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 返回值可取：
     * - pre：在请求路由之前执行
     * - route：在请求路由时调用
     * - post：请求路由之后调用， 也就是在route和errror过滤器之后调用
     * - error：处理请求发生错误时调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre"; //
    }

    @Override
    public int filterOrder() {
        return 1; //返回值是int，会根据返回值进行定义过滤器的执行顺序，值越小优先级越大
    }

    @Override
    public boolean shouldFilter() {
        return true; //当前过滤器是否被执行，true则执行，false不执行
    }

    //定义 过滤功能
    @Override
    public Object run() throws ZuulException {

        //1.获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //如果说请求带了token值，则表示已经登录过
        if(token == null) {
            logger.warn("此操作需要先登录系统");
            //没有登录 过，则不进行路由转发
            context.setSendZuulResponse(false);//拒绝访问
            context.setResponseStatusCode(200); //响应状态码
            try {
                context.getResponse().getWriter().write("token is empty...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //通过，会进行路由转发
        logger.info("通过，会进行路由转发");
        return null;
    }
}
