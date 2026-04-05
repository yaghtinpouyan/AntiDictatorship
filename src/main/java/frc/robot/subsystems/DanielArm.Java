package frc.robot.subsystems.tank;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DanielArm extends SubsystemBase {
  private static DArm armD = null;

  private SparkMax dArmMotor = new SparkMax(1, MotorType.kBrushless);
  private SparkClosedLoopController dArmController = dArmMotor.getClosedLoopController();
  private RelativeEncoder dArmEncoder = dArmMotor.getEncoder();
  private SparkMaxConfig dArmConfig = new SparkMaxConfig();

  private final PIDController cPID = new PIDController(0.001, 0, 0);

  public static getDArm(){
    if (dArm == null) {
        dArm = new dArm();
    }
    return dArm;
  }

  public DanielArm() {
    
  }

  public void dSetArm(double joyRight) {
    if (MathUtil.applyDeadband(joyRight, 0.1) > 0){
        dArmMotor.set(joyRight);
    } else if (MathUtil.applyDeadband(joyRight, 0.1) < 0) {
        dArmMotor.set(joyRight);
    } else {
        dArmMotor.set(0.0);
    }
  }

  public static DanielArm getInstance(){
    if (armD == null){
      armD = new DanielArm();
    }
    return armD;
  }

}