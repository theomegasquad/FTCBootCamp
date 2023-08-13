package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="AnahataAndShreya", group="Linear OpMode")
public class AnahataAndShreya extends LinearOpMode {

    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack;
    public DcMotor leftFront;

    private ElapsedTime runtime= new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialize");
        telemetry.update();


        rightFront = hardwareMap.dcMotor.get("RightFront");
        leftBack = hardwareMap.dcMotor.get("LeftBack");
        rightBack = hardwareMap.dcMotor.get("RightBack");
        leftFront = hardwareMap.dcMotor.get("LeftFront");

        waitForStart();

        runtime.reset();


        while (runtime.seconds() < 4){
            drive(1);
        }

        brake();


    }

    public void drive(double speed){
        rightFront.setPower(-speed);
        leftBack.setPower(-speed);
        rightBack.setPower(speed);
        leftFront.setPower(speed);

    }

    public void brake(){
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
    }
}
