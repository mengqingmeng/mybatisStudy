import mapper.UserMapper;
import model.SysRole;
import model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelect(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = userMapper.selectById(1L);
        Assert.assertNotNull(user);
        Assert.assertEquals("admin",user.getUserName());
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> userList = userMapper.selectAll();
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void testSelectRolesByUserId(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> sysRoleList = userMapper.selectRolesByUserId(1L);
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserEmail("762577099@qq.com");
            user.setUserName("MQM");
            user.setUserPassword("123");
            user.setUserInfo("测试用户");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            int result = userMapper.insertUser(user);
//            sqlSession.commit();
            System.out.println(user.getId());
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1001L);
            sysUser.setUserInfo("测试用户-测试Info");
            int result = userMapper.updateByUserId(sysUser);
//            sqlSession.commit();
            sysUser = userMapper.selectById(1001L);
            System.out.println(sysUser.getUserInfo());
        }finally {

        }
    }

    // 多参数接口
    @Test
    public void testMultiParams(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> sysUserList = userMapper.selectRolesByUserIdAndRoleEnabled(1L,1);

    }
}
