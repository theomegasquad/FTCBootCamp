package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;


@Autonomous(name="Autonomous Servo Sample Continuous", group="Linear Opmode")
public class AutonomousServoSampleContinuous extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;



    public CRServo servo;
    double  speed = 0.4;


    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        servo = hardwareMap.get(CRServo.class, "servo");



        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        while(opModeIsActive()) {
            servo.setPower(speed);

            while (runtime.seconds() < 4){
                telemetry.addData("Direction", "Forward");
                telemetry.update();
            }

            speed *= -1;

        }
        brake();

    }

    public void drive(double speed){
        leftFront.setPower(-speed);
        leftBack.setPower(-speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
    }

    public void driveForTime(double speed, int time){
        runtime.reset();
        while (runtime.seconds() < time){
            leftFront.setPower(-speed);
            leftBack.setPower(-speed);
            rightFront.setPower(speed);
            rightBack.setPower(speed);
        }
        brake();
    }

    public void turn(double leftSpeed, double rightSpeed){
        leftFront.setPower(leftSpeed);
        leftBack.setPower(leftSpeed);
        rightFront.setPower(rightSpeed);
        rightBack.setPower(rightSpeed);
    }

    public void brake(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }


}