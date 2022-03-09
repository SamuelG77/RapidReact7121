// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase 
{

  private CANSparkMax rightArm;
  private CANSparkMax leftArm;
  private RelativeEncoder encoder;
  private DigitalInput rightLimit;
  private DigitalInput leftLimit;
  
  public Climber() 
  {
    rightArm = new CANSparkMax(Constants.rightClimb, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftArm = new CANSparkMax(Constants.leftClimb, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftArm.setInverted(true);
    encoder = rightArm.getEncoder();
    encoder.setPosition(0);
    rightLimit = new DigitalInput(Constants.rightLimitSwitch);
    leftLimit = new DigitalInput(Constants.leftLimitSwitch);
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunMotors(double speed)
  {
    // if(speed > 0 && !rightLimit.get())
    // {
    //   rightArm.set(speed);
    //   leftArm.set(speed);
    // }
    // else if(speed < 0)
    // {
    //   rightArm.set(speed);
    //   leftArm.set(speed);
    // }
    // else
    // {
    //   rightArm.set(0);
    //   leftArm.set(0);
    // }

    rightArm.set(speed);
    leftArm.set(speed);
    
  }
  public void RightMotor(double speed)
  {
    rightArm.set(speed);
  }

  public void LeftMotor(double speed)
  {
    leftArm.set(speed);
  }
}
