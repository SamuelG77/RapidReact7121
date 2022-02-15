// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunUptake;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Uptake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  private Joystick driver;

  //subsystems
  private Shooter shooter;
  private DriveTrain driveTrain;
  private Uptake uptake;
  private Intake intake;

  //commands
  private ArcadeDrive drive;

  public RobotContainer() 
  {
    driver = new Joystick(0);

    shooter = new Shooter();
    driveTrain = new DriveTrain();
    intake = new Intake();
    uptake = new Uptake();

    drive = new ArcadeDrive(driveTrain, driver);

    driveTrain.setDefaultCommand(drive);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {

    //shoot
    JoystickButton xButton = new JoystickButton(driver, Constants.xButton);
    xButton.whileHeld(new Shoot(shooter));

    //uptake
    JoystickButton rbButton = new JoystickButton(driver, Constants.rbButton);
    rbButton.whileHeld(new RunUptake(uptake, Constants.uptakeSpeed));

    JoystickButton lbButton = new JoystickButton(driver, Constants.lbButton);
    lbButton.whileHeld(new RunUptake(uptake, -Constants.uptakeSpeed));
    
    //intake
    JoystickButton rtButton = new JoystickButton(driver, Constants.rtButton);
    rtButton.whileHeld(new RunIntake(intake, Constants.intakeSpeed));

    JoystickButton ltButton = new JoystickButton(driver, Constants.ltButton);
    ltButton.whileHeld(new RunIntake(intake, -Constants.intakeSpeed));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    return null;
  }
}
