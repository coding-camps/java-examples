package jms.openmq01.consumer;
import javax.jms.*;
public class SynReceiver {
    public static void main(String[] args) {
        try {
            ConnectionFactory cf = new com.sun.messaging.ConnectionFactory();
            ((com.sun.messaging.ConnectionFactory)cf).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList,"localhost:7676");
            Connection con = cf.createConnection();
            Session sn = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination dest = sn.createQueue("AQueue");
            MessageConsumer mc = sn.createConsumer(dest);
            con.start();
            TextMessage msg = (TextMessage) mc.receive();
            System.out.println("Received message: "+msg.getText());
            sn.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
