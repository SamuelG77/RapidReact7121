// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase 
{
  /** Creates a new ArcadeDrive. */
  private DriveTrain driveTrain;
  private Joystick joystick;
  public ArcadeDrive(DriveTrain dt,Joystick js) 
  {
    driveTrain = dt;
    joystick = js;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double x = joystick.getRawAxis(Constants.rightX);
    double y = joystick.getRawAxis(Constants.rightY);
    double lSpeed = y + x;
    double rSpeed = y - x;

    driveTrain.setSpeed(lSpeed, rSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    driveTrain.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}