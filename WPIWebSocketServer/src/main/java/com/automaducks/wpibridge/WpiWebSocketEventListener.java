/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

import java.util.EventListener;

interface WpiWebSocketEventListener extends EventListener {
    void onMessage(WpiWebSocketEventMessage message);
}
