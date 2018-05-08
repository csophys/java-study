package books.headfirst.patternDesign.factory.abstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by csophys on 2018/5/7.
 */
public class JDKAbstractFactory {

    public static void main(String[] args) throws SQLException {
        //DriverManager
        Connection xxxx = DriverManager.getConnection("xxxx");

        //Connection为接口
    }
}
