// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase 
{

  private CANSparkMax rightArm;
  private CANSparkMax leftArm;
  
  public Climber() 
  {
    rightArm = new CANSparkMax(Constants.rightClimb, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftArm = new CANSparkMax(Constants.leftClimb, CANSparkMaxLowLevel.MotorType.kBrushless);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunMotors(double speed)
  {
    rightArm.set(speed);
    leftArm.set(speed);
  }
}
