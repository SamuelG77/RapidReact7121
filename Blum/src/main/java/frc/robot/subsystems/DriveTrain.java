// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase 
{

  private CANSparkMax rightFront;
  private CANSparkMax rightFollow;
  private CANSparkMax leftFront;
  private CANSparkMax leftFollow;

  private MotorControllerGroup right;
  private MotorControllerGroup left;

  private Joystick j;

  public DriveTrain() 
  {
    rightFront = new CANSparkMax(Constants.rightFront,CANSparkMaxLowLevel.MotorType.kBrushed);
    rightFollow = new CANSparkMax(Constants.rightFollow,CANSparkMaxLowLevel.MotorType.kBrushed);
    leftFront = new CANSparkMax(Constants.leftFront,CANSparkMaxLowLevel.MotorType.kBrushed);
    leftFollow = new CANSparkMax(Constants.leftFollow,CANSparkMaxLowLevel.MotorType.kBrushed);

    right = new MotorControllerGroup(rightFront, rightFollow);
    //right.setInverted(true);
    left = new MotorControllerGroup(leftFront, leftFollow);

    j = RobotContainer.joystick;


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Drive()
  {
    double x = RobotContainer.joystick.getRawAxis(Constants.rightX);
    double y = RobotContainer.joystick.getRawAxis(Constants.rightY);

    right.set(y+x);
    left.set(y-x);
  }
  public void Stop()
  {
    right.set(0);
    left.set(0);
  }
}
