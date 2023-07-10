package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Autonomous Color Sensor", group="Linear Opmode")
public class AutonomousColorSensor extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    public NormalizedColorSensor cs;

    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        cs = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        drive(0.4);
        while (runtime.seconds() < 16){
            NormalizedRGBA colors = cs.getNormalizedColors();
            if (colors.red >= 0.8){
                drive(0.2);
                sleep(1500);
            }
            else if (colors.blue >= 0.8){
                drive(0.65);
                sleep(1500);
            }
        }
        brake();

    }

    public void drive(double speed){
        leftFront.setPower(-speed);
        leftBack.setPower(-speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
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