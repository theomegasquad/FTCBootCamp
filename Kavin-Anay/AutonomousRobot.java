package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="AutonomousRobot", group= "Linear Opmode")
public class AutonomousRobot extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", " Initialized");
        telemetry.update();


        leftFront = hardwareMap.dcMotor.get("LeftFront");
        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        while (runtime.seconds() < 4) {
            drive(10);
        }

        brake();

    }


    // Left Motors are inverted; negative will go positive, and vice versa
    public void drive(double speed){
        leftBack.setPower(-speed);
        rightBack.setPower(speed);
        leftFront.setPower(-speed);
        rightFront.setPower(speed);
    }

    public void brake(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
}

