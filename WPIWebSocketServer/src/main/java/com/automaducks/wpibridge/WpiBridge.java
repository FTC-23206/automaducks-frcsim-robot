/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

import com.automaducks.wpibridge.messages.WpiMessage;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class WpiBridge {

    private static class WebSocketListener implements WpiWebSocketEventListener {

        private final ObjectMapper objectMapper = new ObjectMapper();

        public final List<WpiBridgeEventListener> listeners = new ArrayList<>();

        @Override
        public void onMessage(WpiWebSocketEventMessage message) {

            try {
                WpiMessage wpiMessage = objectMapper.readValue(message.getMessage(), WpiMessage.class);

                WpiBridgeEventMessage wpiEventMessage = new WpiBridgeEventMessage(wpiMessage);

                for (WpiBridgeEventListener listener : listeners) {
                    listener.onEvent(wpiEventMessage);
                }

            } catch (JacksonException e) {
                System.out.println("Error parsing message: " + e.getMessage());
            }
        }
    }

    private final WpiWebSocketServer server;
    private final WebSocketListener websocketListener;

    public WpiBridge(int port) {

        this.websocketListener = new WebSocketListener();
        this.server = new WpiWebSocketServer(port);

        this.server.addMyEventListener(websocketListener);
    }

    public void addMyEventListener(WpiBridgeEventListener listener) {
        this.websocketListener.listeners.add(listener);
    }

    public void removeMyEventListener(WpiBridgeEventListener listener) {
        this.websocketListener.listeners.remove(listener);
    }

    public void start(){
        this.server.start();
    }

    public void stop() throws InterruptedException {
        this.server.stop();
    }
}
