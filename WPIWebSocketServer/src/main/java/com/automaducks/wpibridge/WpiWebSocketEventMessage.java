/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

class WpiWebSocketEventMessage {

    private final String message;

    public WpiWebSocketEventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
