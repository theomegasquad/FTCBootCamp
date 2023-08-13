package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BackwardsSA", group="Linear Opmode")
public class BackwardsSA extends LinearOpMode {

    public DcMotor RightBack;
    public DcMotor RightFront;
    public DcMotor LeftFront;
    public DcMotor LeftBack;

    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        RightBack = hardwareMap.dcMotor.get("RightBack");
        RightFront = hardwareMap.dcMotor.get("RightFront");
        LeftFront = hardwareMap.dcMotor.get("LeftFront");
        LeftBack = hardwareMap.dcMotor.get("LeftBack");


        waitForStart();

        runtime.reset();

        while (runtime.seconds() < 60) {
            drive(0.4);
        }


        brake();

    }
    public void drive ( double speed){
        RightBack.setPower(-speed);
        RightFront.setPower(-speed);
        LeftFront.setPower(speed);
        LeftBack.setPower(speed);



    }

    public void brake(){
        RightBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
        LeftBack.setPower(0);

    }

}