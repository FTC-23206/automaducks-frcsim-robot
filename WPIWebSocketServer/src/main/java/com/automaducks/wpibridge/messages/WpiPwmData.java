/**
 * Copyright (c) Automaducks - FTC 23206
 * All rights reserved.
 */
package com.automaducks.wpibridge.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WpiPwmData {

    @JsonProperty("<init")
    private boolean init;

    @JsonProperty("<speed")
    private float speed;

    @JsonProperty("<position")
    private float position;

    @JsonProperty("<zero_latch")
    private boolean zeroLatch;

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public boolean isZeroLatch() {
        return zeroLatch;
    }

    public void setZeroLatch(boolean zeroLatch) {
        this.zeroLatch = zeroLatch;
    }
}
