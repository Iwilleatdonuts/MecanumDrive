package frc.robot;

import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;
import com.ctre.phoenixpro.configs.Slot0Configs;
import com.ctre.phoenixpro.controls.DutyCycleOut;
import com.ctre.phoenixpro.controls.VelocityDutyCycle;
import com.ctre.phoenixpro.configs.MotorOutputConfigs;

public class DriveModule extends SubsystemBase {

  private final TalonFX driveMotor;

  public DriveModule(int driveTrainID) {
  
    driveMotor = new TalonFX(driveTrainID);

    Slot0Configs drivePIDConfig = new Slot0Configs();
    drivePIDConfig.kP = DriveTrainConstants.drivekP;
    drivePIDConfig.kI = DriveTrainConstants.drivekI;
    drivePIDConfig.kD = DriveTrainConstants.drivekD;

    MotorOutputConfigs driveConfigs = new MotorOutputConfigs();
    driveConfigs.NeutralMode = NeutralModeValue.Brake;

    driveMotor.getConfigurator().apply(drivePIDConfig);
    driveMotor.getConfigurator().apply(driveConfigs);
  }

  private void setSpeed(double desiredSpeed, boolean isOpenLoop){
    if(isOpenLoop){
      double speed = desiredSpeed/DriveTrainConstants.MaxSpeed;
      driveMotor.setControl(new DutyCycleOut(speed));
    }else{
      driveMotor.setControl(new VelocityDutyCycle(desiredSpeed));
    }
  }

  @Override
  public void periodic() {

  }
}
