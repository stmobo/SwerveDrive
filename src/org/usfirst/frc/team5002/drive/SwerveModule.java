package org.usfirst.frc.team5002.drive.swerve;

import org.usfirst.frc.team5002.drive.Drive;
/**
  This tells what angle the Swerve motors should be pointing
  and what speed the wheels should be going.

@author Zack Vega


*/
private Talon angleMotor;
private Talon speedMotor;
private PIDController pidController;
public final double L = 24.69 ;
public final double W = 22.61 ;

public SwerveModule(int angleMotor, int speedMotor, int encoder){
  this.angleMotor = new Talon (angleMotor);
  this.speedMotor = new Talon (speedMotor);

  pidController = new PIDController (1, 0, 0, new AnalogInput (encoder), this.angleMotor);

  pidController.setOutputRange (-1, 1);
  pidController.setContinuous ();
  pidController.enable ();

  private final double MAX_VOLTS = 12;
}
public void drive (double speed, double angle) {
  speedMotor.set (speed);

  double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5);
  if(setpoint < 0){
      setpoint = MAX_VOLTS + setpoint;
  }
  if(setpoint > MAX_VOLTS){
    setpoint = setpoint - MAX_VOLTS;
  }

  pidController.setSetpoint (setpoint);

}
public void drive( double x, double y, double z){
    double r = Math.sqrt((L * L) + (W * W))
    y *= -1;

    double a = x-z * (L/r);
    double b = x+z * (L/r);
    double c = y-z * (W/r);
    double d = y+z * (W/r);

    double backRightSpeed = Math.sqrt ((a * a) + (d * d));
    double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
    double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
    double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));
  }
