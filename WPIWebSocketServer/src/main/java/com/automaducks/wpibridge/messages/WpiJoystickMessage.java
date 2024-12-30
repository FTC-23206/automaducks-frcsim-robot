/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WpiJoystickMessage extends WpiMessage {

    public WpiJoystickMessage() {
        super(WpiMessageType.Joystick);
    }
}
