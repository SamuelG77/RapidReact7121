// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Uptake;

public class AutoOne extends CommandBase 
{

  private Uptake uptake;
  private Shooter shooter;
  private Timer timer;
  private Lift lift;
  private DriveTrain driveTrain;
  private Intake intake;
  private Limelight limelight;

  public AutoOne() 
  {
    shooter = RobotContainer.shooter;
    uptake = RobotContainer.uptake;
    lift = RobotContainer.lift;
    driveTrain = RobotContainer.driveTrain;
    intake = RobotContainer.intake;
    limelight = RobotContainer.limelight;
    timer = new Timer();

    addRequirements(uptake, shooter, lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  @Override
  public void execute() 
  {

    //shoot first ball
    timer.start();
    while(timer.get()<1)
    {
      shooter.Shoot(.33, .33);
    }
    while(timer.get()<3)
    {
      uptake.setSpeed(.5);
    }
    shooter.Shoot(0, 0);
    uptake.setSpeed(0);
    lift.Toggle();

    //pick up next ball
    driveTrain.ResetEncoder();
    intake.setSpeed(.5);

    while(driveTrain.getRightEncoder() < 170000 && driveTrain.getLeftEncoder() < 170000)
    {
      driveTrain.setSpeed(.5, .5);
      System.out.println(driveTrain.getLeftEncoder() + "  " + driveTrain.getRightEncoder());
    }
    driveTrain.setSpeed(0, 0);

    timer.reset();
    timer.start();
    
    //auto aim
    while(timer.get() < .5)
    {
      driveTrain.setSpeed(-limelight.PID(), limelight.PID());
    }

    intake.setSpeed(0);

    timer.reset();
    timer.start();

    driveTrain.setSpeed(0, 0);

    //shoot second ba;;
    while(timer.get()<1)
    {
      shooter.Shoot(.42, .42);
    }
    while(timer.get()<3)
    {
      uptake.setSpeed(.5);
    }
    shooter.Shoot(0, 0);
    uptake.setSpeed(0);

    end(true);


    
  }

  @Override
  public void end(boolean interrupted) 
  {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}
