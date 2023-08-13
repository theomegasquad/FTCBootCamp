package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Teleop", group= "Linear Opmode")
public class Teleop extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    public Servo servo;
    double position = 0.5;

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront = hardwareMap.dcMotor.get("LeftFront");
        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");

        servo = hardwareMap.get(Servo.class, "servo");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.left_stick_y != 0) {
                leftFront.setPower(-gamepad1.left_stick_y);
                leftBack.setPower(-gamepad1.left_stick_y);
                rightFront.setPower(gamepad1.left_stick_y);
                rightBack.setPower(gamepad1.left_stick_y);
                telemetry.addData("Moving", "sf", gamepad1.left_stick_y);
            } else {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
            }

            if (gamepad1.dpad_left) {
                leftFront.setPower(-1);
                leftBack.setPower(1);
                rightFront.setPower(-1);
                rightBack.setPower(1);
                telemetry.addData("shuffling", "left");
                telemetry.update();
            } else if (gamepad1.dpad_right) {
                leftFront.setPower(1);
                leftBack.setPower(-1);
                rightFront.setPower(1);
                rightBack.setPower(-1);
                telemetry.addData("shuffling", "right");
                telemetry.update();

            }

            if (gamepad1.dpad_up) {
                    leftFront.setPower(-1);
                    leftBack.setPower(-1);
                    rightFront.setPower(1);
                    rightBack.setPower(1);
            }
                servo.setPosition(0.0);
            }

            if (gamepad1.b) {
                servo.setPosition(1.0);

            }

            if (gamepad1.x) {
                servo.setPosition(0.5);
            }
        }
    }
}