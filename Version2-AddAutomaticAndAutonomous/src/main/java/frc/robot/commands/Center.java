// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Center extends CommandBase 
{
  private Limelight limelight;
  private DriveTrain driveTrain;
  private double motorSpeed;
  /** Creates a new Center. */
  public Center(Limelight ll, DriveTrain dt) 
  {
    limelight = ll;
    driveTrain = dt;
    addRequirements(limelight);
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    motorSpeed = limelight.PID();
    driveTrain.setSpeed(-motorSpeed, motorSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    driveTrain.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
  
}
