package top.mengtech.springboot_mybatis.security;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @ClassName JwtUserDetailService
 * @Description
 * @Author MQM
 * @Date 2020-02-16 18:02
 */

@Service
public class JwtUserDetailService implements UserDetailsService {
    private final String userName = "javainuse";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /**
         * 在实际开发中，可以在这里根据用户名查询数据库，
         * 然后将数据库中的用户数据封装成UserDetails
         */
        if (s.equals(userName)){
            return new User(userName,"$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("未找到用户：" + userName);
        }
    }
}
