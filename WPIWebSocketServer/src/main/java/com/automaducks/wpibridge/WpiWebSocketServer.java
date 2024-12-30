/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

class WpiWebSocketServer extends WebSocketServer {

    private final List<WpiWebSocketEventListener> listeners = new ArrayList<>();

    public WpiWebSocketServer(int port) {
        this(new InetSocketAddress(InetAddress.getLoopbackAddress(), port));
    }

    public void addMyEventListener(WpiWebSocketEventListener listener) {
        listeners.add(listener);
    }

    public void removeMyEventListener(WpiWebSocketEventListener listener) {
        listeners.remove(listener);
    }

    public WpiWebSocketServer(InetSocketAddress socketAddress) {
        super(socketAddress);

        System.out.println("Listening on " + socketAddress);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {

        WpiWebSocketEventMessage event = new WpiWebSocketEventMessage(message);

        //System.out.println("Message: " + message);

        for (WpiWebSocketEventListener listener: listeners) {
            listener.onMessage(event);
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {

    }
}
