// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Joint;

public class RotateJoint extends CommandBase 
{

  private Joint joint;
  private Joystick joystick;
  public RotateJoint(Joint j, Joystick joy) 
  {
    joint = j;
    joystick = joy;
    addRequirements(joint);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    joint.MoveRightJoint(joystick.getRawAxis(Constants.leftY)/2.5);
    joint.MoveLeftJoint(joystick.getRawAxis(Constants.rightY)/2.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    joint.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
