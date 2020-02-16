package top.mengtech.springboot_mybatis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.mengtech.springboot_mybatis.jwt.JwtRequest;

/**
 * @ClassName JwtAuthenticationController
 * @Description
 * @Author MQM
 * @Date 2020-02-16 18:21
 */

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest){

    }
}
