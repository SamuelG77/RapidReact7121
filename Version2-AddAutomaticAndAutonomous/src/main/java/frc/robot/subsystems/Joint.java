// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Joint extends SubsystemBase 
{
  private WPI_VictorSPX rightJoint;
  private WPI_VictorSPX leftJoint;

  public Joint() 
  {
    rightJoint = new WPI_VictorSPX(Constants.rightJoint);
    leftJoint = new WPI_VictorSPX(Constants.leftJoint);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void MoveLeftJoint(double speed)
  {
    leftJoint.set(speed);
  }

  public void MoveRightJoint(double speed)
  {
    rightJoint.set(speed);
  }

  public void Stop()
  {
    rightJoint.set(0);
    leftJoint.set(0);
  }
}
