import mapper.RoleMapper;
import model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import type.Enabled;

import java.util.List;

public class RoleMapperTest extends BaseMapperTest{
    @Test
    public void testSelectRoleByUserId(){
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectRolesByUserId(1001L);
            roleList.stream().forEach(sysRole -> {
                System.out.println(sysRole);
            });
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRole(){
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectRoleById(1L);
            sysRole.setEnabled(Enabled.enabled);
            int result = roleMapper.updateRoleById(sysRole);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleCached(){
        SqlSession sqlSession = getSqlSession();
        SysRole role1 = null;
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            role1 = roleMapper.selectRoleById(1L);
            SysRole role2 = roleMapper.selectRoleById(1L);
            Assert.assertEquals(role1,role2);
        }finally {
            sqlSession.close();
        }

        sqlSession = getSqlSession();
        System.out.println("开启新的sqlSession");
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole sysRole3 = roleMapper.selectRoleById(1L);
            SysRole sysRole4 = roleMapper.selectRoleById(1L);
            Assert.assertNotEquals(role1,sysRole3);
            Assert.assertNotEquals(sysRole3,sysRole4);
        }finally {
            sqlSession.close();
        }
    }
}
