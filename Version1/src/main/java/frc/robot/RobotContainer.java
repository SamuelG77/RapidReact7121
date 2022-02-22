// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Center;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunUptake;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.GearBox;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Limelight;
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

  //other
  public static Joystick driver;
  public static Joystick shootJoystick;
  private Timer timer;

  //subsystems
  private Shooter shooter;
  public static Lift lift;
  public static GearBox gearBox;
  public static DriveTrain driveTrain;
  private Uptake uptake;
  private Intake intake;
  private Limelight limelight;

  //commands
  private ArcadeDrive drive;

  public RobotContainer() 
  {

    //other
    driver = new Joystick(Constants.driverJoystick);
    shootJoystick = new Joystick(Constants.shooterJoystick);
    timer = new Timer();
    timer.reset();

    //subsytems
    shooter = new Shooter();
    driveTrain = new DriveTrain();
    intake = new Intake();
    uptake = new Uptake();
    lift = new Lift();
    gearBox = new GearBox();
    limelight = new Limelight();

    //commands
    drive = new ArcadeDrive(driveTrain);

    //default commands
    driveTrain.setDefaultCommand(drive);

    SmartDashboard.getEntry("stream");


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

    //shoot (shooter joystick)
    JoystickButton aButton = new JoystickButton(shootJoystick, Constants.aButton);
    aButton.whileHeld(new Shoot(shooter, .32, .32));

    JoystickButton bButton = new JoystickButton(shootJoystick, Constants.bButton);
    bButton.whileHeld(new Shoot(shooter, .42, .42));

    JoystickButton yButton = new JoystickButton(shootJoystick, Constants.yButton);
    yButton.whileHeld(new Shoot(shooter, .6, .6));

    //limelight
    JoystickButton xButton = new JoystickButton(shootJoystick, Constants.xButton);
    xButton.whileHeld(new Center(limelight, driveTrain));


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
