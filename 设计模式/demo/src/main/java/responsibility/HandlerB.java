package responsibility;

public class HandlerB extends AbsHandler {
    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)){
            System.out.println(this.getClass().getSimpleName()+" 处理: "+request);
            return;
        }
        if( null != this.next ){
            this.next.handleRequest(request);
        }
    }
}
