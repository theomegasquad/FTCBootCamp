package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Driver_boi",group = "Linear OpMode")

public class OpMode2 extends LinearOpMode {


    public DcMotor LeftFront;
    public DcMotor RightFront;
    public DcMotor LeftBack;
    public DcMotor RightBack;

    public TouchSensor Touchyboi;

    public CRServo Servo1;


    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        LeftFront = hardwareMap.dcMotor.get("LeftFront");
        RightFront = hardwareMap.dcMotor.get("RightFront");
        LeftBack = hardwareMap.dcMotor.get("LeftBack");
        RightBack = hardwareMap.dcMotor.get("RightBack");
        Servo1 = hardwareMap.crservo.get("Servo1");
        Touchyboi = hardwareMap.get(TouchSensor.class,"Touchyboi");




        waitForStart();

        while(opModeIsActive()) {



            if (gamepad1.left_stick_y != 0) {
                LeftFront.setPower(gamepad1.left_stick_y);
                LeftBack.setPower(-gamepad1.left_stick_y);
                RightFront.setPower(-gamepad1.left_stick_y);
                RightBack.setPower(gamepad1.left_stick_y);
                telemetry.update();
            } else {
                LeftFront.setPower(0);
                LeftBack.setPower(0);
                RightBack.setPower(0);
                RightFront.setPower(0);


            }
            if (gamepad1.dpad_left) {
                LeftFront.setPower(1);
                LeftBack.setPower(-1);
                RightBack.setPower(-1);
                RightFront.setPower(1);
                telemetry.addData("shuffling", "left");
                telemetry.update();
            } else if (gamepad1.dpad_right) {
                LeftFront.setPower(-1);
                LeftBack.setPower(1);
                RightBack.setPower(1);
                RightFront.setPower(-1);
                telemetry.addData("shuffling", "right");
                telemetry.update();
            } else {
                LeftFront.setPower(0);
                LeftBack.setPower(0);
                RightBack.setPower(0);
                RightFront.setPower(0);
            }

            if (gamepad1.left_stick_x != 0) {
                Servo1.setPower(1);
                LeftFront.setPower(-gamepad1.left_stick_x);
                LeftBack.setPower(-gamepad1.left_stick_x);
                RightFront.setPower(-gamepad1.left_stick_x);
                RightBack.setPower(-gamepad1.left_stick_x);
                telemetry.addData("turning", "left or right");
                telemetry.update();

            } else {
                Servo1.setPower(0);
                LeftFront.setPower(0);
                LeftBack.setPower(0);
                RightBack.setPower(0);
                RightFront.setPower(0);
            }













        }
    }


}
