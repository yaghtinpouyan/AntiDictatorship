package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

public final class Constants {
  public enum Mode {
    REAL,
    SIM,
    REPLAY
  }

  // Change this to Mode.REPLAY when you want to replay a .wpilog file in sim.
  public static final Mode simMode = Mode.SIM;

  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  private Constants() {}
}
