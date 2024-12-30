/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WpiDriverStationMessage extends WpiMessage {

    public WpiDriverStationMessage() {
        super(WpiMessageType.DriverStation);
    }
}
