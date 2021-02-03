package jms.openmq01.consumer;

import javax.jms.*;

public class AsynListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        TextMessage tm = (TextMessage) msg;
        try {
            System.out.println("Received: " + tm.getText());
        } catch (Exception e) { e.printStackTrace(); }
    }
}
