package base.jdbc;

import base.jdbc.dao.dao.TestDao;
import base.jdbc.dao.myDao.MyTestDao;
import org.junit.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

/**
 * Created by Administrator on 2016/3/6.
 */
public class JavaDBOperateDemo {

    public static void main(String[] args) throws Exception {
        JDBC();
        DataSource();
        // Zebra(DAL) 设计思路
    }

    private static void DataSource() {
        // 数据源，连接池 与JDBC 区别
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:datasource.xml");
        /**
         * c3p0
         */
        TestDao testDao = classPathXmlApplicationContext.getBean(TestDao.class);
        /**
         * myDatasource
         */
        MyTestDao myTestDao = classPathXmlApplicationContext.getBean(MyTestDao.class);
        Assert.assertEquals(testDao.getLatest(), myTestDao.getLatest());
    }

    private static void JDBC() throws ClassNotFoundException, SQLException {
        //1. 注册DriverManager,DriverManager中的静态List registeredDrivers 保存了所有的Driver引用

        Class.forName("com.mysql.jdbc.Driver");

        //2.拼接连接信息，协议/子协议/数据源标识，连接信息
        String url = "jdbc:mysql://localhost:3306/csc?user=root&password=4216";

        //3. DriverManager 负责从注册的驱动中挑选合适的连接
        Connection connection = DriverManager.getConnection(url);

        //4. 建立陈述式语句 (Statement,PrepareStatement(安全性[防止sql注入]和性能),CallableStatement（存储过程）)

        //4.1 Statement
        Statement statement = connection.createStatement();
        //execute query
        ResultSet resultSet = statement.executeQuery("SELECT  * FROM test ORDER by ID limit 10");
        //4.2 PrepareStatement，在一个提交中设置了多个陈述式语句。
        connection.setAutoCommit(false);
        PreparedStatement preparedStatementInsert = connection.prepareStatement("INSERT  into test(name,sex) VALUES (?,?)");
        preparedStatementInsert.setString(1, "csophys");
        preparedStatementInsert.setInt(2, 0);
        preparedStatementInsert.execute();
        Statement getLastIdStatement = connection.createStatement();
        ResultSet set = getLastIdStatement.executeQuery("SELECT LAST_INSERT_ID()");
        connection.commit();

        //4.3 statement 的batch的功能以及CallableStatement平时用的不多

        //5. 处理返回结果ResultSet
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString("id"));
        }
        while(set.next()){
            System.out.println(set.getString(1));
            System.out.println(set.getString("LAST_INSERT_ID()"));
        }
    }

}
