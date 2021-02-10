package com.serversys.web.component;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.serversys.utils.ResultMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xzw
 * 拦截运行异常出现的错误
 */
@ControllerAdvice
@Data
@ConfigurationProperties("exceptionhandler")
public class WebExceptionHandler {
    private Boolean isInsertDb;
    /**
     * 拦截运行异常出现的错误~~~
     *
     * @return ResultMessage
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultMessage exceptionHandler(RuntimeException e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> enu = request.getParameterNames();
        String url =  request.getRequestURL().toString();
        ErrorException errorException = new ErrorException();
        Map<String,Object> map = errorException.getArgs();
        errorException.setUrl(url);
        errorException.setRequestMethod(request.getMethod());
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            map.put(name,request.getParameter(name));
            errorException.setArgs(map);
        }
        errorException.setMsg(e.getMessage());
        errorException.setClazz(e.getClass().getName());
        errorException.setIp(request.getRemoteAddr());
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(errorException);
        if(isInsertDb){
            System.out.println("写入数据库："+jsonObject.toJSONString());
        }
        return ResultMessage.erreo(ResultMessage.FAILCODE,jsonObject,e.getMessage());
    }
}

@Data
class ErrorException{
    private String url;
    private String requestMethod;
    private Map<String,Object> args = new HashMap<>();
    private String msg;
    private String clazz;
    private String ip;
}
