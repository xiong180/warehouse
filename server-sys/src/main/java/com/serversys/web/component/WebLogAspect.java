package com.serversys.web.component;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xzw
 * 切面实现日志功能
 */
@Aspect
@Component
@Slf4j
@Data
@ConfigurationProperties(prefix = "webaspect")
public class WebLogAspect {
	private Boolean isInsertDb;

	@Pointcut("execution(public * com.serversys.web.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws IOException {
		HttpServletRequest request = null;
		Object[] args = joinPoint.getArgs();
		// 参数名
		String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
		Map<String, Object> map = new HashMap<>();
		int i = 0;
		boolean isRequest = false;
		for (; i < argNames.length; i++) {
			if(args[i] instanceof HttpServletRequest){
				isRequest = true;
				request = (HttpServletRequest) args[i];
			}else {
				map.put(argNames[i],args[i]);
				log.info("参数名:{},参数值:{}", argNames[i],args[i]);
			}
		}
		log.info("参数个数:{}",i);
		// 接收到请求，记录请求内容
		if(!isRequest){
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			assert attributes != null;
			request = attributes.getRequest();
		}else{
			Enumeration<String> enu = request.getParameterNames();
			if(enu.hasMoreElements()){
				while (enu.hasMoreElements()) {
					String name = enu.nextElement();
					map.put(name,request.getParameter(name));
				}
			}else{
				map.put("jsonPost","jsonPost");
			}

		}
		// 记录下请求内容
		log.info("URL : " + request.getRequestURL().toString());
		log.info("请求方式 : " + request.getMethod());
		log.info("IP地址 : " + request.getRemoteAddr());

		if(isInsertDb){
			ErrorException errorException = new ErrorException();
			errorException.setRequestMethod(request.getMethod());
			errorException.setUrl(request.getRequestURL().toString());
			errorException.setIp(request.getRemoteAddr());
			errorException.setArgs(map);
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(errorException);
			System.out.println("写入数据库："+jsonObject.toJSONString());
		}
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) {
		// 处理完请求，返回内容
		log.info("处理完请求，返回内容 : " + ret);
	}
}
