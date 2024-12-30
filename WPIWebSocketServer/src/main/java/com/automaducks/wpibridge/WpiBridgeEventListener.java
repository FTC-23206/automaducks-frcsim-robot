/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge;

import java.util.EventListener;

public interface WpiBridgeEventListener extends EventListener {
    void onEvent(WpiBridgeEventMessage eventMessage);
}
