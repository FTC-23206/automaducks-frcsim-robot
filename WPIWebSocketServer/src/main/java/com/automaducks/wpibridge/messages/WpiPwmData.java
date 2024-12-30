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
    private Boolean init;

    @JsonProperty("<speed")
    private Float speed;

    @JsonProperty("<position")
    private Float position;

    @JsonProperty("<zero_latch")
    private Boolean zeroLatch;

    public Boolean isInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getPosition() {
        return position;
    }

    public void setPosition(Float position) {
        this.position = position;
    }

    public Boolean isZeroLatch() {
        return zeroLatch;
    }

    public void setZeroLatch(Boolean zeroLatch) {
        this.zeroLatch = zeroLatch;
    }
}
