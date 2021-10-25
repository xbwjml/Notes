package proto;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProtoB implements Cloneable, Serializable {

    private String desc;

    private ArrayList<String> hobby = new ArrayList();

    public ProtoB(){
        System.out.println("构造方法");
    }

    @Override
    public ProtoB clone() {
        ProtoB obj = null;
        try {
            obj = (ProtoB) super.clone();
            this.hobby = (ArrayList) this.hobby.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public ProtoB deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ProtoB) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}