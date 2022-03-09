// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase 
{
  PWMSparkMax rightSide;
  PWMSparkMax leftSide;
  Joystick joystick;
  public DriveTrain() 
  {
    rightSide = new PWMSparkMax(0);
    rightSide.setInverted(true);
    leftSide = new PWMSparkMax(1);
    joystick = RobotContainer.joystick;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Drive()
  {
    double x = joystick.getRawAxis(Constants.rightX);
    double y = joystick.getRawAxis(Constants.rightY);
    rightSide.set((y+x));
    leftSide.set((y-x));
  }
  public void Stop()
  {
    rightSide.set(0);
    leftSide.set(0);
  }
}
