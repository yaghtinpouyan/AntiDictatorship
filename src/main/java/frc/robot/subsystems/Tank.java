package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tank extends SubsystemBase {
    
  double LFMValue;
  double RFMValue;

   private SparkMax leftFrontMotor;
   private SparkMax rightFrontMotor;
   private SparkMax leftBackMotor;
   private SparkMax rightBackMotor;

  private static Tank tank = null;
   public static Tank getInstance(){
    if (tank == null){
      tank = new Tank();
    }
    return tank;
  }
  public Tank(){
    
    SparkMaxConfig ConfigLF = new SparkMaxConfig();
    SparkMaxConfig ConfigLB = new SparkMaxConfig();
    SparkMaxConfig ConfigRF = new SparkMaxConfig();
    SparkMaxConfig ConfigRB = new SparkMaxConfig();
    
    ConfigLB.inverted(true).follow(4);
    ConfigLF.inverted(true);

    ConfigRB.follow(5);
    
    leftBackMotor = new SparkMax(2, MotorType.kBrushless);
    rightBackMotor = new SparkMax(3, MotorType.kBrushless);
    leftFrontMotor = new SparkMax(4, MotorType.kBrushless);
    rightFrontMotor = new SparkMax(5, MotorType.kBrushless);

    leftFrontMotor.configure(ConfigLF, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftBackMotor.configure(ConfigLB, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightFrontMotor.configure(ConfigRF, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightBackMotor.configure(ConfigRB, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void manualDrive(double joyright, double joyleft){
    
    joyleft = MathUtil.applyDeadband(joyleft, 0.1);
    joyright = MathUtil.applyDeadband(joyright, 0.1);

    LFMValue = (joyleft - joyright);
    RFMValue = (joyleft + joyright);

    double max = Math.max(Math.abs(LFMValue), Math.abs(RFMValue));
    if (max > 1.0) {
        LFMValue /= max;
        RFMValue /= max;
    }

    leftFrontMotor.set(LFMValue);
    rightFrontMotor.set(RFMValue);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Right Motor is ", RFMValue);
    SmartDashboard.putNumber("Left Motor is ", LFMValue); 
  }

    
}