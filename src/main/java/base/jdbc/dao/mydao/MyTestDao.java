package base.jdbc.dao.myDao;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/3/6.
 */
public interface MyTestDao {

    @Select("select Id from test order by id desc limit 1")
    int getLatest();
}
