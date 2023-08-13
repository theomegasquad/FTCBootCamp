package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Driver Controlled Sample", group = "Linear Opmode")
public class DriveControl extends LinearOpMode {

    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;
    public DcMotor leftFront;

    public Servo servo;
    double position = 0.5;

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");
        leftFront = hardwareMap.dcMotor.get("LeftFront");

        servo = hardwareMap.get(Servo.class, "servo");


        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.left_stick_y !=0) {
                rightFront.setPower(gamepad1.left_stick_y);
                leftBack.setPower(-gamepad1.left_stick_y);
                rightBack.setPower(gamepad1.left_stick_y);
                leftFront.setPower(-gamepad1.left_stick_y);
                telemetry.addData("Moving", "%f", gamepad1.left_stick_y);
                telemetry.update();
            }
            else {
                rightFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                leftFront.setPower(0);
            }

            if (gamepad1.dpad_left){
                rightFront.setPower(-1);
                leftBack.setPower(-1);
                rightBack.setPower(1);
                leftFront.setPower(1);
                telemetry.addData("Shuffling", "left");
                telemetry.update();
            }

            else if (gamepad1.dpad_right){
                rightFront.setPower(1);
                leftBack.setPower(1);
                rightBack.setPower(-1);
                leftFront.setPower(-1);
                telemetry.addData("Shuffling", "right");
                telemetry.update();
            }

            else {
                rightFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                leftFront.setPower(0);
            }

            if  (gamepad1.left_stick_x != 0) {
                rightFront.setPower(-gamepad1.left_stick_x);
                leftBack.setPower(-gamepad1.left_stick_x);
                rightBack.setPower(-gamepad1.left_stick_x);
                leftFront.setPower(-gamepad1.left_stick_x);
                telemetry.addData("Turning", "left or right");
                telemetry.update();
            }
            else {
                rightFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                leftFront.setPower(0);
            }

            if (gamepad1.a){
                servo.setPosition(0.0);
            }

            if (gamepad1.b){
                servo.setPosition(1.0);
            }
        }
    }
}

