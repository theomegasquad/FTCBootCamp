package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "TouchSensorSA", group="LinearOpMode")
public class TouchSensorSA extends LinearOpMode {


    public DcMotor RightBack;
    public DcMotor RightFront;
    public DcMotor LeftFront;
    public DcMotor LeftBack;

    public TouchSensor touch;

    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        RightBack = hardwareMap.dcMotor.get("RightBack");
        RightFront = hardwareMap.dcMotor.get("RightFront");
        LeftFront = hardwareMap.dcMotor.get("LeftFront");
        LeftBack = hardwareMap.dcMotor.get("LeftBack");

        touch = hardwareMap.get(TouchSensor.class, "touchsensor");

        waitForStart();


        while (opModeIsActive()) {
            runtime.reset();

            drive(0.6);
            while (touch.isPressed()) {
                brake();


            }
        }
    }

    public void drive(double speed) {
        RightBack.setPower(speed);
        RightFront.setPower(speed);
        LeftFront.setPower(-speed);
        LeftBack.setPower(-speed);
    }

    public void turn(double leftSpeed, double rightSpeed) {
        RightBack.setPower(rightSpeed);
        RightFront.setPower(rightSpeed);
        LeftFront.setPower(leftSpeed);
        LeftBack.setPower(leftSpeed);
    }

    public void brake() {
        RightBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
        LeftBack.setPower(0);
    }
}