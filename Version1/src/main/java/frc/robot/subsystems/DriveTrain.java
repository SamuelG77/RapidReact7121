// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase 
{
  private WPI_TalonFX rightFront;
  private WPI_TalonFX rightFollow;
  private WPI_TalonFX leftFront;
  private WPI_TalonFX leftFollow;
  private MotorControllerGroup rightSide;
  private MotorControllerGroup leftSide;

  private boolean isInverted;
  private Timer timer;

  public DriveTrain() 
  {
    isInverted = true;
    timer = new Timer();
    timer.reset();
    timer.start();
    

    rightFront = new WPI_TalonFX(Constants.rightFront);
    rightFollow = new WPI_TalonFX(Constants.rightFollow);
    leftFront = new WPI_TalonFX(Constants.leftFront);
    leftFollow = new WPI_TalonFX(Constants.leftFollow);

    rightSide = new MotorControllerGroup(rightFront, rightFollow);
    rightSide.setInverted(true);
    leftSide = new MotorControllerGroup(leftFront, leftFollow);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double lSpeed, double rSpeed)
  {
    rightSide.set(rSpeed);
    leftSide.set(lSpeed);
  }

  public void Inverte()
  {
    
    if(timer.get() > .5)
    {
      isInverted = !isInverted;
      timer.reset();
      timer.start();
    }
  }

  public void Drive()
  {
    double x = RobotContainer.driver.getRawAxis(Constants.rightX);
    double y = RobotContainer.driver.getRawAxis(Constants.rightY);
    double lSpeed = y - x;
    double rSpeed = y + x;
    double invertRSpeed = -(y - x);
    double invertLSpeed = -(y + x);
    boolean drive = false;

    if(rSpeed >.02 || lSpeed > .02 || rSpeed < -.02 || lSpeed < -.02 )
      drive = true;
    else
    {
      setSpeed(0, 0);
      drive = false;
    }

    if(drive && isInverted)
    {
      setSpeed(invertLSpeed, invertRSpeed);
    }
    else if(drive)
    {
      setSpeed(lSpeed, rSpeed);
    }
  }

  
}
