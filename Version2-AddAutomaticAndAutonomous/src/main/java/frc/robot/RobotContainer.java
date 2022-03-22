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
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.Center;
import frc.robot.commands.Climb;
import frc.robot.commands.LeftClimb;
import frc.robot.commands.RightClimb;
import frc.robot.commands.RotateJoint;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunUptake;
import frc.robot.commands.Shoot;
import frc.robot.commands.Autonomous.AutoOne;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.GearBox;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Joint;
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
  public static Joystick second;
  private Timer timer;

  //subsystems
  public static Shooter shooter;
  public static Lift lift;
  public static GearBox gearBox;
  public static DriveTrain driveTrain;
  public static Uptake uptake;
  public static Intake intake;
  public static Limelight limelight;
  public static Climber climber;
  private Joint joint;

  //commands
  private ArcadeDrive drive;
  private RotateJoint rotate;

  public RobotContainer() 
  {

    //other
    driver = new Joystick(Constants.driverJoystick);
    second = new Joystick(Constants.secondJoystick);
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
    climber = new Climber();
    joint = new Joint();

    //commands
    drive = new ArcadeDrive(driveTrain);
    rotate = new RotateJoint(joint, second);

    //default commands
    driveTrain.setDefaultCommand(drive);
    joint.setDefaultCommand(rotate);

    SmartDashboard.getEntry("stream");
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);

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
    // JoystickButton xButton = new JoystickButton(driver, Constants.xButton);
    // xButton.whileHeld(new Shoot(shooter, Constants.lowSpeedShoot, Constants.lowSpeedShoot));

    // JoystickButton bButton = new JoystickButton(driver, Constants.bButton);
    // bButton.whileHeld(new Shoot(shooter, Constants.midSpeedShoot, Constants.midSpeedShoot));

    // JoystickButton yButton = new JoystickButton(driver, Constants.yButton);
    // yButton.whileHeld(new Shoot(shooter, Constants.highSpeedShoot, Constants.highSpeedShoot));

    JoystickButton xButton = new JoystickButton(driver, Constants.xButton);
    xButton.whileHeld(new Shoot(shooter, Constants.onePointUpper, Constants.onePointLower));

    JoystickButton r3Button = new JoystickButton(driver, Constants.r3Button);
    r3Button.whileHeld(new AutoShoot(limelight, shooter, driveTrain));

    //limelight
    JoystickButton l3Button = new JoystickButton(driver, Constants.l3Button);
    l3Button.whileHeld(new Center(limelight, driveTrain));


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

    //climb
    JoystickButton rbButtonS = new JoystickButton(second, Constants.rbButton);
    rbButtonS.whileHeld(new RightClimb(climber, Constants.climbSpeed));
  
    JoystickButton lbButtonS = new JoystickButton(second, Constants.lbButton);
    lbButtonS.whileHeld(new LeftClimb(climber, Constants.climbSpeed));

    JoystickButton rtButtonS = new JoystickButton(second, Constants.rtButton);
    rtButtonS.whileHeld(new RightClimb(climber, -Constants.climbSpeed));

    JoystickButton ltButtonS = new JoystickButton(second, Constants.ltButton);
    ltButtonS.whileHeld(new LeftClimb(climber, -Constants.climbSpeed));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    return new AutoOne();
  }
}
