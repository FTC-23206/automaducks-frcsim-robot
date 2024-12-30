/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

import com.automaducks.wpibridge.messages.WpiMessage;

public class WpiBridgeEventMessage {

    private final WpiMessage wpiMessage;

    public WpiBridgeEventMessage(WpiMessage wpiMessage) {
        this.wpiMessage = wpiMessage;
    }

    public WpiMessage getWpiMessage() {
        return wpiMessage;
    }
}
