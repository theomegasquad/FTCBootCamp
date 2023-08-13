package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="SimpleTeleOpsCode", group ="Linear OpMode")
public class SimpleTeleOpsCode extends LinearOpMode {

    public DcMotor RightBack;
    public DcMotor RightFront;
    public DcMotor LeftFront;
    public DcMotor LeftBack;

    public Servo servo;
    double position = 0.25;

    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        RightBack = hardwareMap.dcMotor.get("RightBack");
        RightFront = hardwareMap.dcMotor.get("RightFront");
        LeftFront = hardwareMap.dcMotor.get("LeftFront");
        LeftBack = hardwareMap.dcMotor.get("LeftBack");

        servo = hardwareMap.get(Servo.class, "servo");

        waitForStart();

        while (opModeIsActive()) {

// Forward and Backward Section
            if (gamepad1.left_stick_y !=0){
                RightBack.setPower(-gamepad1.left_stick_y);
                RightFront.setPower(-gamepad1.left_stick_y);
                LeftFront.setPower(gamepad1.left_stick_y);
                LeftBack.setPower(gamepad1.left_stick_y);
                telemetry.addData("Moving", "%f", gamepad1.left_stick_y);
                telemetry.update();

            }

            else {
                RightBack.setPower(0);
                RightFront.setPower(0);
                LeftFront.setPower(0);
                LeftBack.setPower(0);
            }
// Left Joystick Left Tilt
            if (gamepad1.dpad_left) {
                RightBack.setPower(-0.5);
                RightFront.setPower(0.5);
                LeftFront.setPower(0.5);
                LeftBack.setPower(-0.5);
                telemetry.addData("Shuffling", "left");
                telemetry.update();
            }
// Left Joystick Right Tilt
            else if (gamepad1.dpad_right) {
                RightBack.setPower(0.5);
                RightFront.setPower(-0.5);
                LeftFront.setPower(-0.5);
                LeftBack.setPower(0.5);
                telemetry.addData("Shuffling", "right");
                telemetry.update();
            }

            else {
                RightBack.setPower(0);
                RightFront.setPower(0);
                LeftFront.setPower(0);
                LeftBack.setPower(0);
            }
//Left and Right Section?
            if (gamepad1.left_stick_x !=0) {
                RightBack.setPower(-gamepad1.left_stick_x);
                RightFront.setPower(-gamepad1.left_stick_x);
                LeftFront.setPower(-gamepad1.left_stick_x);
                LeftBack.setPower(-gamepad1.left_stick_x);
                telemetry.addData("Turning", "left of right");
                telemetry.update();
            }
            else {
                RightBack.setPower(0);
                RightFront.setPower(0);
                LeftFront.setPower(0);
                LeftBack.setPower(0);
            }

            if (gamepad1.a) {
                servo.setPosition(0.0);

            }
            if (gamepad1.b) {
                servo.setPosition(8.0);
            }

        }

    }
}