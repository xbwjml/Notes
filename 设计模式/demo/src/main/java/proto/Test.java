package proto;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ProtoA a = new ProtoA();
        a.setDesc("a");
        ProtoA aClone = a.clone();
        aClone.setDesc("aclone");

        ProtoB b = new ProtoB();
        ArrayList<String> list = new ArrayList<>();
        list.add("read");
        list.add("sleep");
        b.setHobby(list);

        ProtoB bClone = b.clone();

        b.getHobby().add("打游戏!!");
        bClone.getHobby().add("唱歌");

        return;
    }
}
