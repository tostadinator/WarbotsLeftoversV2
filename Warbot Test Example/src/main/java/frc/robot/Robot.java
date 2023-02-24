// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//package edu.wpi.first.wpilibj.examples.arcadedrivexboxcontroller;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
//import java.lang.ModuleLayer.Controller;
import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
 private final TalonSRX m_leftDrive = new TalonSRX(40);
  private final TalonSRX m_rightDrive = new TalonSRX(41);
  private final VictorSPX m_kicker = new VictorSPX(36);
  //private final DifferentialDrive m_robotDrive = new DifferentialDrive (m_leftDrive, m_rightDrive);
 // private final XboxController Controller  = new XboxController(0);
  private final Timer m_timer = new Timer();


  private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;
  private static final int kEncoderPortA = 0;
  private static final int kEncoderPortB = 1;

  /** 
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightDrive.setInverted(true);
   // m_leftDrive.set(ControlMode.PercentOutput, 0);
   // m_rightDrive.set(ControlMode.PercentOutput, 0);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      // Drive forwards half speed, make sure to turn input squaring off
 //     m_robotDrive.arcadeDrive(0.5, 0.0, false);
    } else {
  //    m_robotDrive.stopMotor(); // stop robot
    }
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
  //  m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
 // m_robotDrive.arcadeDrive(-m_driverController.getLeftY(), -m_driverController.getRightX());
 m_leftDrive.set(ControlMode.PercentOutput, -0.8);
 m_rightDrive.set(ControlMode.PercentOutput, -0.8);
 m_kicker.set(ControlMode.PercentOutput,-0.9);
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
