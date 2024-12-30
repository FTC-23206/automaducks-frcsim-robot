/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WpiPwmMessage extends WpiMessage {

    private WpiPwmData data;

    public WpiPwmMessage() {
        super(WpiMessageType.PWM);
    }

    public WpiPwmData getData() {
        return data;
    }

    public void setData(WpiPwmData data) {
        this.data = data;
    }
}
