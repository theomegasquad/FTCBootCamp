package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "touchSensor", group="Linear Opmode")
public class touchSensor extends LinearOpMode {

    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;
    public DcMotor leftFront;

    public TouchSensor touch;

    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");
        leftFront = hardwareMap.dcMotor.get("LeftFront");

        touch = hardwareMap.get(TouchSensor.class, "Touch");

        waitForStart();

        while(opModeIsActive()) {
            runtime.reset();

            drive(0.4);
            while (touch.isPressed()) {
                brake();
            }
        }

    }

    public void drive(double speed){
        rightFront.setPower(speed);
        leftBack.setPower(-speed);
        rightBack.setPower(speed);
        leftFront.setPower(-speed);
    }

    public void turn(double leftSpeed, double rightSpeed){
        rightFront.setPower(rightSpeed);
        leftBack.setPower(leftSpeed);
        rightBack.setPower(rightSpeed);
        leftFront.setPower(leftSpeed);

    }

    public void brake() {
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
    }
}
