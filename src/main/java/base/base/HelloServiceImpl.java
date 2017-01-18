package base.base;

/**
 * Created by csophys on 16/10/18.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello"+name;
    }
}
