package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {

  private final DriveModule mod0;
  private final DriveModule mod1;
  private final DriveModule mod2;
  private final DriveModule mod3;

  public Drive() {
    mod0 = new DriveModule(RobotMap.Mod0.driveMotorID);
    mod1 = new DriveModule(RobotMap.Mod1.driveMotorID);
    mod2 = new DriveModule(RobotMap.Mod2.driveMotorID);
    mod3 = new DriveModule(RobotMap.Mod3.driveMotorID);
  }

  @Override
  public void initialize() {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
