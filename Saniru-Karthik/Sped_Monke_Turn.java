package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "Autonomous Turn", group = "Linear Opmode")
public class Sped_Monke_Turn extends LinearOpMode {

    public DcMotor LeftFront;
    public DcMotor RightFront;
    public DcMotor LeftBack;
    public DcMotor RightBack;

    private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LeftFront = hardwareMap.dcMotor.get("LeftFront");
        RightFront = hardwareMap.dcMotor.get("RightFront");
        LeftBack = hardwareMap.dcMotor.get("LeftBack");
        RightBack = hardwareMap.dcMotor.get("RightBack");


        waitForStart();


        runtime.reset();

        while (runtime.seconds() < 4) {
            drive(0.7);
        }
        brake();

    }

    public void drive(double speed) {
        LeftFront.setPower(-speed);
        LeftBack.setPower(-speed);
        RightBack.setPower(-speed);
        RightFront.setPower(-speed);

    }

    public void brake() {
        LeftFront.setPower(0);
        LeftBack.setPower(0);
        RightBack.setPower(0);
        RightFront.setPower(0);


    }


}
