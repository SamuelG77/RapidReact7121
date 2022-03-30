// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


public final class Constants 
{
    /*****************Joystick map*****************/
    public static final int driverJoystick = 0;
    public static final int secondJoystick = 1;
    //axis
    public static final int leftX = 0;
    public static final int leftY = 1;
    public static final int rightX = 2;
    public static final int rightY = 3;
    //buttons
    public static final int xButton = 1;
    public static final int aButton = 2;
    public static final int bButton = 3;
    public static final int yButton = 4;
    public static final int lbButton = 5;
    public static final int rbButton = 6;
    public static final int ltButton = 7;
    public static final int rtButton = 8;
    public static final int backButton = 9;
    public static final int startButton = 10;
    public static final int l3Button = 11;
    public static final int r3Button = 12;

    /*****************CAN*****************/
    //TalonFX
    public static final int rightFront = 4;
    public static final int rightFollow = 5;
    public static final int leftFront = 6;
    public static final int leftFollow = 7;
    public static final int lowerFlyWheel = 3;
    public static final int upperFlyWheel = 2;
    //victorSPX
    public static final int uptake = 1;
    public static final int intake = 0;
    public static final int rightJoint = 15;
    public static final int leftJoint = 16;
    //SparkMax
    public static final int rightClimb = 10;
    public static final int leftClimb = 20;

    /*****************OTHER*****************/
    public static final double uptakeSpeed = .25;
    public static final double intakeSpeed = .40;
    public static final double climbSpeed = 1;
    public static final double kp = .01;
    public static final double minCommand = .012;
    public static final double kd = .05;
    public static final int rightLimitSwitch = 0;
    public static final int leftLimitSwitch = 1;
    //shooting speeds
    public static final double highSpeedShoot = .6;
    public static final double midSpeedShoot = .42;
    public static final double lowSpeedShoot = .32;
    public static final double onePointUpper = .22;
    public static final double onePointLower = .22;
    public static final double autoLevel1 = .35;
    public static final double autoLevel2 = .39;
    public static final double autoLevel3 = .42;
    public static final double autoLevel4 = .44;



}
