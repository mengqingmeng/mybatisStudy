package plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CameHumpInterceptor
 * @Description mybatis Map类型下划线key转为小写骆驼形式
 * @Author MQM
 * @Date 2020-02-11 12:00
 */

@Intercepts(@Signature(type= ResultSetHandler.class,method="handleResultSets",args={Statement.class}))
public class CameHumpInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 先执行
        List<Object> list = (List<Object>) invocation.proceed();
        for(Object o:list){
            if (o instanceof Map){
                processMap((Map)o);
            }else {
                break;
            }
        }

        return list;
    }

    /**
     * 处理Map数据
     * @param map
     */
    private void processMap(Map map){
        Set<String> keySet = new HashSet<String>(map.keySet());
        for(String key : keySet){
            // 大写开头 或 包含 _
            if ((key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') || key.indexOf("_") >= 0){
                // 替换key
                Object value = map.get(key);
                map.remove(key);
                map.put(underlineToCamelhump(key),value);
            }
        }
    }

    /**
     * 将下划线风格（包含大写开头）转为驼峰风格
     * @param key map的key
     * @return 转换后的key
     */
    private String underlineToCamelhump(String key){
        StringBuilder stringBuilder = new StringBuilder();

        // 标记下一个字符是否应该大写
        boolean nextUpperCase = false;

        for(int i=0;i<key.length();i++){
            char c = key.charAt(i);
            if(c == '_'){
                if (stringBuilder.length()>0){
                    nextUpperCase = true;
                }
            }else{
                // 该大写就大写，否则小写
                if(nextUpperCase){
                    stringBuilder.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                }else{
                    stringBuilder.append(Character.toLowerCase(c));
                }
            }
        }
        return stringBuilder.toString();
    }
}
