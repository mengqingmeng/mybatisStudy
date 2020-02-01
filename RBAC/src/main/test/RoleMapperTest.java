import mapper.RoleMapper;
import model.SysRole;
import org.apache.ibatis.session.SqlSession;
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
}
