// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase 
{
  private Limelight limelight;
  private Shooter shooter;
  private DriveTrain driveTrain;
  public AutoShoot(Limelight ll, Shooter s, DriveTrain dt) 
  {
    limelight = ll;
    shooter = s;
    driveTrain = dt;
    addRequirements(limelight, shooter, driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double motorSpeed = limelight.PID();
    driveTrain.setSpeed(motorSpeed, -motorSpeed);

    double y = limelight.getY();
    
    if(y > 7)
    {
      shooter.Shoot(.25, .25);
    }
    else if(y > 4)
    {
      shooter.Shoot(.32, .33);
    }
    if(y > 2.5)
    {
      shooter.Shoot(.38, .39);
    }
    else if(y > -1)
    {
      shooter.Shoot(.4, .41);
    }
    else
    {
      shooter.Shoot(0, 0);
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
