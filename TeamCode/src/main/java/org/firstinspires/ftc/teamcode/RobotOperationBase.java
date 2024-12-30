/**
 * Copyright (c) 2023 Automaducks - FTC 23206
 * All rights reserved.
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.RobotLog;



/**
 * Base class for all robot operation modes
 * <p>
 * It initializes all robot subsystems and define basic operation stages:
 * - onStart : executes on OpMode initialization
 * - onRun : executes on OpMode run
 * - onStop : executes on OpMode stop
 */
public abstract class RobotOperationBase extends LinearOpMode {

    private final ElapsedTime periodicElapsedTime = new ElapsedTime();
    private final String logTag;
    private final ElapsedTime runtime = new ElapsedTime();


    /**
     * Common class initialization.
     */
    protected RobotOperationBase() {
        this.logTag = "RobotOperationBase";
    }

    /**
     * Runs the robot operation mode by splitting it in 3 sections:
     * -onStart
     * -onRun
     * -onStop
     * @throws InterruptedException when interrupted.
     */
    @Override
    public void runOpMode() throws InterruptedException {

        WpiWebsocketServer myClass = new WpiWebsocketServer(10);

        try {
            // Emit telemetry prior waiting for start
//            telemetry.putData("Status", "Is Awesome!!");
//            telemetry.flush(false);

            // Init
            runtime.reset();

            onStart();

            while (!isStarted()) {
                //periodic();
                sleep(20);
            }

            // Run
            runtime.reset();
            onRun();
        }
        finally {

            try {
                onStop();

                runtime.reset();
//                telemetry.flush(true);
            }
            catch (Exception e){
                RobotLog.ee("RobotOperationBase", e, "Error on cleanup.");
            }
        }
    }

    /**
     * Initializes basic robot functions.
     * @throws InterruptedException when interrupted.
     */
    protected abstract void onStart() throws InterruptedException;

    /**
     * Runs the operation mode.
     * @throws InterruptedException when interrupted.
     */
    protected abstract void onRun() throws InterruptedException;

    /**
     * Executes code prior stopping the operation.
     */
    protected abstract void onStop();

    /**
     * Gets the standard log tag for this class.
     * @return standard log tag.
     */
    protected String getLogTag() {
        return logTag;
    }
}