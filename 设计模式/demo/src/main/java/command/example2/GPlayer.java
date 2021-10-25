package command.example2;

/**
 * 具体Receievr
 */
public class GPlayer {

    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("更改播放速度");
    }

    public void stop(){
        System.out.println("终止播放");
    }

    public void pause(){
        System.out.println("暂停");
    }
}
