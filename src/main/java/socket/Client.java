package socket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

//https://www.youtube.com/watch?v=paFm6xKjqWg
public class Client extends WebSocketClient {

    private Date openedTime;
    private final SocketContext context;

    public Client(SocketContext context) throws URISyntaxException {
        super(new URI(context.getURI()));
        this.context = context;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        openedTime = new Date();
        System.out.println("Connection established ! : "+context.getURI());

    }

    @Override
    public void onMessage(String message) {
        System.out.println("New message received. : " + message);
        context.getMessageList().add(message);
        if(message.equals(context.getExpectedMessage())){
            closeConnection(1000, "Expected message received!");
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("The socket was closed with code "  + code+ "The reason is : "+reason);
        context.setStatusCode(code);
    }

    @Override
    public void onError(Exception ex) {

    }

    public int getAliveTime(){
            Date closedDate = new Date();
            int timeInSeconds = (int) (closedDate.getTime() - openedTime.getTime())/1000;
            context.setTimeTaken(timeInSeconds);
            return timeInSeconds;
    }
}
