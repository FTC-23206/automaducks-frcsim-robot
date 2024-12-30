package com.automaducks.wpibridge.test;

import com.automaducks.wpibridge.WpiBridge;
import com.automaducks.wpibridge.WpiBridgeEventListener;
import com.automaducks.wpibridge.WpiBridgeEventMessage;
import com.automaducks.wpibridge.messages.WpiMessage;
import com.automaducks.wpibridge.messages.WpiPwmMessage;

import org.junit.jupiter.api.Test;

public class WebSocketServerTests {

    private class WpiBridgeListener implements WpiBridgeEventListener {

        @Override
        public void onEvent(WpiBridgeEventMessage eventMessage) {

            WpiMessage wpiMessage = eventMessage.getWpiMessage();

            switch (wpiMessage.getType()) {
                case PWM:
                    WpiPwmMessage pwmMessage = (WpiPwmMessage) wpiMessage;

                    System.out.printf(
                        "PWM received. Device: %s, Init: %b, Speed: %.2f, Position: %.2f, ZL: %b \n",
                        pwmMessage.getDevice(),
                        pwmMessage.getData().isInit(),
                        pwmMessage.getData().getSpeed(),
                        pwmMessage.getData().getPosition(),
                        pwmMessage.getData().isZeroLatch());

                    break;
                case Joystick:
                case DriverStation:
                default:
                    //System.out.println("Other message received: " + wpiMessage.getType());
                    break;
            }
        }
    }

    @Test
    public void runServer() throws Exception {
        WpiBridgeListener listener = new WpiBridgeListener();

        int port = 3300;
        WpiBridge bridge = new WpiBridge(port);
        bridge.addMyEventListener(listener);
        bridge.start();

        Thread.sleep(300000);

        bridge.stop();
    }
}