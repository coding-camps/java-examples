package jms.openmq01.consumer;
import javax.jms.*;
public class AsynReceiver {
    public static void main(String[] args) {
        try {
            ConnectionFactory conFactory = new com.sun.messaging.ConnectionFactory();
            ((com.sun.messaging.ConnectionFactory)conFactory).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList,"localhost:7676");
            Connection con = conFactory.createConnection();
            Session sn = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination dest = sn.createQueue("AQueue");
            MessageConsumer mc = sn.createConsumer(dest);
            con.start();
            mc.setMessageListener(new AsynListener());
            System.out.println("Continuing its own work");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
