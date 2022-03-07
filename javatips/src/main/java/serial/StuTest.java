package serial;

import java.io.*;

public class StuTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        serialize();
        deserialize();
    }

    public static void serialize() throws IOException {
        Student student = new Student();
        student.setName("CodeSheep");
        student.setAge( 18 );
        student.setScore( 1000 );

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("student.txt") ) );
        objectOutputStream.writeObject( student );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
    }

    public static void deserialize(  ) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("student.txt") ) );
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( student );
    }

}
