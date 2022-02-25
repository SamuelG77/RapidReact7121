// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Limelight extends SubsystemBase 
{
  /** Creates a new Limelight. */
  private NetworkTable limelight;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  private double motorSpeed;


  public Limelight()
  {
    limelight = NetworkTableInstance.getDefault().getTable("limelight");
    SmartDashboard.getEntry("stream");
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
    tx = limelight.getEntry("tx");
    ty = limelight.getEntry("ty");
    ta =limelight.getEntry("ta");
  }

  public double getX()
  {
    return tx.getDouble(0.0);
  }

  public double getY()
  {
    return ty.getDouble(0.0);
  }

  public double getA()
  {
    return ta.getDouble(0.0);
  }

  public double PID()
  {
    motorSpeed = getX() * Constants.kp;
    double x = getX();
    double heading_error = -x;
    double steering_adjust = 0.0;
    if (x > 1.0)
    {
      steering_adjust = Constants.kp*heading_error - Constants.minCommand;
    }
    else if (x < 1.0)
    {
      steering_adjust = Constants.kp*heading_error + Constants.minCommand;
    }
    motorSpeed -= steering_adjust;
    motorSpeed = motorSpeed/2;
    
    return motorSpeed;
  }
}
