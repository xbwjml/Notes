package proto;

import lombok.Data;

@Data
public class ProtoA implements Cloneable{

    private String desc;

    @Override
    public ProtoA clone() {
        ProtoA obj = null;
        try {
            obj = (ProtoA) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
