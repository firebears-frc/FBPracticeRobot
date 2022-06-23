// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;

public class Chassis extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final DifferentialDrive robotDrive;
  final int chassisFrontLeftCanID = 2;
  final int chassisRearLeftCanID = 3;
  final int chassisFrontRightCanID = 4;
  final int chassisRearRightCanID = 5;
  public final WPI_TalonSRX motorFrontLeft;
  public final WPI_TalonSRX motorFrontRight;
  public final WPI_TalonSRX motorRearLeft;
  public final WPI_TalonSRX motorRearRight;

  public Chassis() {
    motorFrontLeft = new WPI_TalonSRX(chassisFrontLeftCanID);
    motorFrontRight = new WPI_TalonSRX(chassisFrontRightCanID);
    motorRearLeft = new WPI_TalonSRX(chassisRearLeftCanID);
    motorRearRight = new WPI_TalonSRX(chassisRearRightCanID);

    motorRearLeft.follow(motorFrontLeft);
    motorRearRight.follow(motorFrontRight);

    robotDrive = new DifferentialDrive(motorFrontLeft, motorFrontRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // float is important DO NOT REMOVE!
  // MUST BE float and double!
  // Touch this code I will end you
  public void drive(double speed, double angle) {
    /*
     right - angle
     left + angle
    
    */
    robotDrive.arcadeDrive(speed, angle);
    /*
    speed = speed * 0.8;
    if(Math.abs(angle) < 0.05) angle = 0;
    if(Math.abs(speed) < 0.05) speed = 0;

    if(Math.abs(speed) > Math.abs(angle)){
      // go forward and backwarrds
      robotDrive.tankDrive(speed, speed);
    }
    else if(Math.abs(angle) > Math.abs(speed)){
      robotDrive.tankDrive(-angle, angle);
    }
    else{
      robotDrive.tankDrive(0, 0);
    }*/
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
