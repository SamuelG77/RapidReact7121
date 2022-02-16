// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Timer;
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

  private MotorControllerGroup right;
  private MotorControllerGroup left;

  private boolean isInverted;
  private Timer timer;

  public DriveTrain() 
  {
    rightFront = new WPI_TalonFX(Constants.rightFront);
    rightFollow = new WPI_TalonFX(Constants.rightFollow);
    leftFront = new WPI_TalonFX(Constants.leftFront);
    leftFollow = new WPI_TalonFX(Constants.leftFollow);

    right = new MotorControllerGroup(rightFront, rightFollow);
    right.setInverted(true);
    left = new MotorControllerGroup(leftFront, leftFollow);

    isInverted = false;
    timer = new Timer();
    timer.start();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Drive()
  {
    right.set(RobotContainer.driver.getRawAxis(Constants.rightY));
    left.set(RobotContainer.driver.getRawAxis(Constants.leftY));
  }

  public void Inverte()
  {
    
    if(timer.get() > .5)
    {
      isInverted = !isInverted;
      right.setInverted(!isInverted);
      left.setInverted(isInverted);
      timer.reset();
      timer.start();
    }
  }

}
