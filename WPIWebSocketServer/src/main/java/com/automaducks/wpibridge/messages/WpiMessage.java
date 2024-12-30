/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge.messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type" )
@JsonSubTypes({
    @JsonSubTypes.Type(value = WpiPwmMessage.class, name = "PWM"),
    @JsonSubTypes.Type(value = WpiJoystickMessage.class, name = "Joystick"),
    @JsonSubTypes.Type(value = WpiDriverStationMessage.class, name = "DriverStation"),
})
public abstract class WpiMessage {
    private final WpiMessageType type;
    private int device;

    protected WpiMessage(WpiMessageType type) {
        this.type = type;
    }

    // Getters and setters
    public WpiMessageType getType() {
        return this.type;
    }

    public int getDevice() {
        return this.device;
    }

    public void setDevice(int device) {
        this.device = device;
    }
}
