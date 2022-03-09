// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase 
{

  private DoubleSolenoid lift;
  private boolean isUp;
  private Timer timer;


  public Lift() 
  {
    timer = new Timer();
    lift = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,2,3);
    lift.set(DoubleSolenoid.Value.kReverse);
    isUp = true;
    timer.start();
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void setFor()
  {
    lift.set(DoubleSolenoid.Value.kForward);
  }

  public void setBack()
  {
    lift.set(DoubleSolenoid.Value.kReverse);
  }

  public void Toggle()
  {
    if(timer.get()> .5)
    {
      lift.toggle();
    }

      isUp = !isUp;
      timer.reset();
      timer.start();
  }

  
  
  
}
