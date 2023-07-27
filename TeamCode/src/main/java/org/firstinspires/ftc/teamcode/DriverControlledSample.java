package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Driver Controlled Sample", group="Linear Opmode")
public class DriverControlledSample extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;


    public Servo servo;
    double  position = 0.5;


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        servo = hardwareMap.get(Servo.class, "servo");


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            if (gamepad1.left_stick_y != 0) {
                leftFront.setPower(-gamepad1.left_stick_y);
                leftBack.setPower(-gamepad1.left_stick_y);
                rightFront.setPower(gamepad1.left_stick_y);
                rightBack.setPower(gamepad1.left_stick_y);
                telemetry.addData("Moving", "%f", gamepad1.left_stick_y);
                telemetry.update();
            }
            else {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
            }

            //Dpad right makes robot shuffle left
            if (gamepad1.dpad_left) {
                leftFront.setPower(1);
                leftBack.setPower(-1);
                rightFront.setPower(-1);
                rightBack.setPower(1);
                telemetry.addData("Shuffling", "left");
                telemetry.update();
            }

            //Dpad left makes robot shuffle right
            else if (gamepad1.dpad_right) {
                leftFront.setPower(-1);
                leftBack.setPower(1);
                rightFront.setPower(1);
                rightBack.setPower(-1);
                telemetry.addData("Shuffling", "right");
                telemetry.update();
            }
            else {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
            }

            //Left Joystick makes robot turn
            if (gamepad1.left_stick_x != 0) {
                leftFront.setPower(-gamepad1.left_stick_x);
                leftBack.setPower(-gamepad1.left_stick_x);
                rightFront.setPower(-gamepad1.left_stick_x);
                rightBack.setPower(-gamepad1.left_stick_x);
                telemetry.addData("Turning", "left or right");
                telemetry.update();
            }
            else {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
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
