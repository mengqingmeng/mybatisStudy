package top.mengtech.springboot_mybatis.filter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;
import top.mengtech.springboot_mybatis.jwt.JwtTokenUtil;
import top.mengtech.springboot_mybatis.security.JwtUserDetailService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求过滤器
 */
@Component
@Slf4j
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
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String token = httpServletRequest.getHeader("Authorization");

        String name = null;
        String jwtToken = null;

        if(token != null && token.startsWith("Bearer ")){
            jwtToken = token.substring(7);
            try{
                name = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException e){
                System.out.printf("Unable to get JWT Token");
            }catch (ExpiredJwtException e){
                System.out.println("JWT token has expired");
            }
        }else{
            System.out.println("请求中不含token");
        }

        SecurityContext context1 = SecurityContextHolder.getContext();

        if(name != null ){
            UserDetails userDetails = jwtUserDetailService.loadUserByUsername(name);
            if(jwtTokenUtil.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                SecurityContext context2 = SecurityContextHolder.getContext();
                // TODO:这Authentication
                System.out.println(context1 == context2? "相等":"不" );

            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
