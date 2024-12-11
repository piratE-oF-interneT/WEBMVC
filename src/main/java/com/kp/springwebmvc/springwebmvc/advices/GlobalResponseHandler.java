package com.kp.springwebmvc.springwebmvc.advices;

import java.util.function.Predicate;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.core.MethodParameter;
//import org.springframework.data.jpa.repository.query.EqlParser.New_valueContext;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		// TODO Auto-generated method stub
		
		Predicate<Object> bodyInstanceTest = x -> x instanceof ApiResponse<?>;
		
		if (!bodyInstanceTest.test(body)) {
			return new ApiResponse<>(body);
		}
		
		return body;
	}

}
