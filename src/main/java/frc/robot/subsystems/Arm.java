package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private SparkMax ArmMotor = new SparkMax(1, MotorType.kBrushless);
  private static Arm arm = null;
  
  public static Arm getInstance(){
    if (arm == null){
      arm = new Arm();
    }
    return arm;
  }

  public Arm(){
    
  }
   public void setArmMotor(double joyRight){
    if(MathUtil.applyDeadband(joyRight , 0.1 ) > 0 ){
      ArmMotor.set(0.7);
    }
    else if(MathUtil.applyDeadband(joyRight , 0.1 ) < 0 ){
      ArmMotor.set(-7);
    }
    else{
      ArmMotor.set(0);
    }
  }

} //:p