// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase 
{
  private WPI_TalonFX upperFly;
  private WPI_TalonFX lowerFly;

  public Shooter() 
  {
    upperFly = new WPI_TalonFX(Constants.upperFlyWheel);
    lowerFly = new WPI_TalonFX(Constants.lowerFlyWheel);
    upperFly.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot(double upperSpeed, double lowerSpeed)
  {
    upperFly.set(upperSpeed);
    lowerFly.set(lowerSpeed);
  }

  public void stop()
  {
    upperFly.set(0);
    lowerFly.set(0);
  }
}
