package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name= "j", group="LinearOpmode")
public class MayonaiseOnAutonomusForward extends LinearOpMode {

    public DcMotor rightfront;
    public DcMotor leftfront;
    public DcMotor leftback;
    public DcMotor rightback;


    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftfront = hardwareMap.dcMotor.get("leftfront");
        rightfront = hardwareMap.dcMotor.get("rightfront");
        leftback = hardwareMap.dcMotor.get("leftback");
        rightback = hardwareMap.dcMotor.get("rightback");

        waitForStart();

        runtime.reset();

        while (runtime.seconds() < 100){
            drive(0.25);
        }
        brake();
    }


// Left motors are inverted and the right motors are normal
    public void drive(double speed){
        leftfront.setPower(speed);
        rightfront.setPower(-speed);
        leftback.setPower(speed);
        rightback.setPower(-speed);
    }

    public void brake(){
        leftfront.setPower(0);
        rightfront.setPower(0);
        leftback.setPower(0);
        rightback.setPower(0);
    }
}