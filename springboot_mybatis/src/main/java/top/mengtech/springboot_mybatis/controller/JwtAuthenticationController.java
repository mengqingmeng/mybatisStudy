package top.mengtech.springboot_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.mengtech.springboot_mybatis.jwt.JwtRequest;
import top.mengtech.springboot_mybatis.jwt.JwtResponse;
import top.mengtech.springboot_mybatis.jwt.JwtTokenUtil;
import top.mengtech.springboot_mybatis.security.JwtUserDetailService;

import java.util.Optional;

/**
 * @ClassName JwtAuthenticationController
 * @Description
 * @Author MQM
 * @Date 2020-02-16 18:21
 */

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtUserDetailService userDetailService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setUserDetailService(JwtUserDetailService jwtUserDetailService){
        this.userDetailService = jwtUserDetailService;
    }
    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil){
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        authenticate(jwtRequest.getUserName(),jwtRequest.getPassword());
        final UserDetails userDetails = userDetailService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.of(Optional.of(new JwtResponse(token)));
    }

    private void authenticate(String username,String password) throws Exception{
        try{
            // 封装Token给Spring Security校验
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }

    }
}
