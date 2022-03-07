package serial;

import java.io.*;

public class PerTest {
    public static void main(String[] args) throws Exception{
        serialize();
        deserialize();
    }

    public static void serialize() throws IOException {
        Person person = new Person();
        person.setName("tom");
        person.setAge( "28" );

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("person.txt") ) );
        objectOutputStream.writeObject( person );
        objectOutputStream.close();

        System.out.println("序列化成功！person.txt文件");
        System.out.println("==============================================");
    }

    public static void deserialize(  ) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("person.txt") ) );
        Person person = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( person );
    }
}
