package mock;

import base.jdbc.MyDataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;

/**
 * Created by csophys on 2017/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:datasource.xml")
public class MockWithSpring {

    @Resource
    ApplicationContext applicationContext;

    @Resource
    MyDataSource myDataSource;

    @Mock
    MyDataSource myDataSource2;

    @Spy
    @Resource
    MyDataSource myDataSource3;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(myDataSource2.getJdbcUrl()).thenReturn("hello");
        when(myDataSource3.getJdbcUrl()).thenReturn("hello");
    }
    @Test
    public void getSpringBean(){
        System.out.println(applicationContext);
        System.out.println(myDataSource);
        Assert.assertEquals("hello",myDataSource2.getJdbcUrl());
        Assert.assertEquals("hello",myDataSource3.getJdbcUrl());
        Assert.assertNotNull(myDataSource3.getUser());
        System.out.println(myDataSource3.getUser());

    }
}
