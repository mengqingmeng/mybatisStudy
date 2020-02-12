package plugin;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName PageRowBounds
 * @Description 可以记录总条数的分页参数
 * @Author MQM
 * @Date 2020-02-12 10:46
 */

@Getter
@Setter
public class PageRowBounds extends RowBounds {
    private long total;
    public PageRowBounds(){super();}
    public PageRowBounds(int offset,int limit){super(offset,limit);}
}
