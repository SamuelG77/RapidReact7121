// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase 
{
  private WPI_TalonFX rightFront;
  private WPI_TalonFX rightFollow;
  private WPI_TalonFX leftFront;
  private WPI_TalonFX leftFollow;
  private MotorControllerGroup rightSide;
  private MotorControllerGroup leftSide;

  private boolean isInverted;

  public DriveTrain() 
  {
    isInverted = true;

    rightFront = new WPI_TalonFX(Constants.rightFront);
    rightFollow = new WPI_TalonFX(Constants.rightFollow);
    leftFront = new WPI_TalonFX(Constants.leftFront);
    leftFollow = new WPI_TalonFX(Constants.leftFollow);

    rightSide = new MotorControllerGroup(rightFront, rightFollow);
    rightSide.setInverted(isInverted);
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
    isInverted = !isInverted;
    rightSide.setInverted(isInverted);
    rightSide.setInverted(!isInverted);

  }
}
