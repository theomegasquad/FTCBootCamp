package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="VeryTouchingCode_Autonomous", group="Linear Opmode")
public class VeryTouchingCode_Autonomous extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    public TouchSensor Touch;

    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront = hardwareMap.dcMotor.get("LeftFront");
        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");

        Touch = hardwareMap.get(TouchSensor.class, "Touch");

        waitForStart();

        while (opModeIsActive()) {
           runtime.reset();

           drive(0.4);
           while (Touch.isPressed()) {
               brake();
           }
        }
    }


    public void drive(double speed) {
        leftBack.setPower(-speed);
        rightBack.setPower(-speed);
        leftFront.setPower(speed);
        rightFront.setPower(speed);
    }

    public void turn(double leftSpeed, double rightSpeed) {
        leftFront.setPower(leftSpeed);
        leftBack.setPower(leftSpeed);
        rightFront.setPower(rightSpeed);
        rightBack.setPower(rightSpeed);
    }
    public void brake() {
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
}


