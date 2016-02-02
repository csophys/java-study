package spring.bean;

import lombok.Data;

/**
 * Created by csophys on 15/12/20.
 */
@Data
public class Model {
    private String name;

    private String sex;

    Model(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

}
