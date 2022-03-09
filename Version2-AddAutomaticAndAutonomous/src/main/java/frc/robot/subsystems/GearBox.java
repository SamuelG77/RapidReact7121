// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GearBox extends SubsystemBase 
{
  private DoubleSolenoid gearBox;
  private Timer timer;
  
  public GearBox() 
  {
    gearBox = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,1);
    gearBox.set(DoubleSolenoid.Value.kReverse);
    timer = new Timer();
    timer.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Toggle()
  {
    if(timer.get() <= .5)
    {
      gearBox.toggle();
    }
    timer.reset();
    timer.start();
  }
}
