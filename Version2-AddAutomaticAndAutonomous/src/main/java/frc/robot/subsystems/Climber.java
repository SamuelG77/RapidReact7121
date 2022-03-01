// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase 
{

  private CANSparkMax rightArm;
  private CANSparkMax leftArm;
  private RelativeEncoder encoder;
  
  public Climber() 
  {
    rightArm = new CANSparkMax(Constants.rightClimb, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftArm = new CANSparkMax(Constants.leftClimb, CANSparkMaxLowLevel.MotorType.kBrushless);
    encoder.setPosition(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunMotors(double speed)
  {
    if(speed < 0 && encoder.getPosition() > Constants.climbMax)
    {
      rightArm.set(speed);
      leftArm.set(speed);
    }
    else if(speed > 0 && encoder.getPosition() < 0)
    {
      rightArm.set(speed);
      leftArm.set(speed);
    }
    else
    {
      rightArm.set(0);
      leftArm.set(0);
    }
  }
}
