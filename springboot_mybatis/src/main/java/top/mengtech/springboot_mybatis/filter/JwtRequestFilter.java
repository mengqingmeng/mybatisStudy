package top.mengtech.springboot_mybatis.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import top.mengtech.springboot_mybatis.jwt.JwtTokenUtil;
import top.mengtech.springboot_mybatis.security.JwtUserDetailService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private JwtUserDetailService jwtUserDetailService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public void setJwtUserDetailService(JwtUserDetailService jwtUserDetailService){
        this.jwtUserDetailService = jwtUserDetailService;
    }
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil){
        this.jwtTokenUtil = jwtTokenUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
