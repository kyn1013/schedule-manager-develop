package com.example.scheduledevelop.core.filter;

import com.example.scheduledevelop.core.common.exception.InvalidPasswordException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;


@Slf4j
public class LoginFilter implements Filter {
    public static final String[] WHITE_LIST = {"/auth/signup", "/auth/login", "/auth/session"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // ServletRequest는 기능이 적기 때문에 HttpServletRequest로 다운캐스팅
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        log.info("로그인 필터 실행");

        // 검증을 제회하는 URI에 포함되지 않은 경우 검증 실행
        if (!isWhiteList(requestURI)){
            // 세션이 존재하지 않는다면 생성하지 않음 (= 로그인을 하지 않았다는 의미)
            HttpSession session = httpServletRequest.getSession(false);
            if (session == null || session.getAttribute("loginUser") == null) {
                throw new InvalidPasswordException();
            }
        }

        // 더 이상 호출할 필터가 없으면 Servlet 바로 호출
        chain.doFilter(request,response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
