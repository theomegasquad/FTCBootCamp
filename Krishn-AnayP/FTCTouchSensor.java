package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Autonomous Touch Sensor", group = "Chunky Donkey")
public class FTCTouchSensor extends LinearOpMode {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;

    public TouchSensor touch;

    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
                telemetry.update();

        leftFront = hardwareMap.dcMotor.get("leftfront");
        rightFront = hardwareMap.dcMotor.get("rightfront");
        leftBack = hardwareMap.dcMotor.get("leftback");
        rightBack = hardwareMap.dcMotor.get("rightback");

        touch = hardwareMap.get(TouchSensor.class, "touch");

        //Wait for the game to start (driver presses PLAY)
         waitForStart();

         while (opModeIsActive()) {
             runtime.reset();

             drive(0.4);
             while(touch.isPressed()) {
                 brake();

             }
         }

    }

    public void drive(double speed){
        leftFront.setPower(-speed);
        leftBack.setPower(-speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
    }

      public void brake(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
}
