// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase 
{

  private double speed;
  private Climber climber;

  public Climb(Climber climber, double speed) 
  {
    this.climber = climber;
    this.speed = speed;

    addRequirements(climber);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() 
  {
    climber.RunMotors(speed);
  }

  @Override
  public void end(boolean interrupted) 
  {
    climber.RunMotors(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
