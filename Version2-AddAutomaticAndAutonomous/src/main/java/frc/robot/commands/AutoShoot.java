// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase 
{
  private Limelight limelight;
  private Shooter shooter;
  public AutoShoot(Limelight ll, Shooter s) 
  {
    limelight = ll;
    shooter = s;
    addRequirements(limelight, shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double y = limelight.getY();
    
    if(y < -10)
    {
      shooter.Shoot(Constants.midSpeedShoot, Constants.midSpeedShoot);
    }
    else
    {
      shooter.Shoot(Constants.lowSpeedShoot, Constants.lowSpeedShoot);
    }
    System.out.println(limelight.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    shooter.Shoot(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
