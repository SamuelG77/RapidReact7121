// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Uptake extends SubsystemBase 
{
  /** Creates a new Uptake. */
  private WPI_VictorSPX uptake;

  public Uptake() 
  {
    uptake = new WPI_VictorSPX(Constants.uptake);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed)
  {
    uptake.set(speed);
  }
}
