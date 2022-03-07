package serial;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    //private static final long serialVersionUID = -3784262205823101377L;

    private String name;
    private Integer age;
    private Integer score;

    private static String add = "上海";
}
