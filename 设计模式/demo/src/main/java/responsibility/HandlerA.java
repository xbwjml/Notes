package responsibility;

public class HandlerA extends AbsHandler{
    @Override
    public void handleRequest(String request) {
        if ("requestA".equals(request)){
            System.out.println(this.getClass().getSimpleName()+" 处理: "+request);
            return;
        }
        if( null != this.next ){
            this.next.handleRequest(request);
        }
    }
}
