package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.gamepad.OI;
import frc.robot.subsystems.Training;

public class Drive extends CommandBase
{
    /**
     * Bring in Subsystem and Gamepad code
     */
    private static Training m_train;
    private static OI m_oi;


    private static double Left = 0;
    private static double Right = 0;
    private static double Back = 0;
    private static double Lift = 0;
    /**
     * Joystick inputs
     */
    double inputLeftY = 0;
    double inputLeftX = 0;
    double inputRightY = 0;
    double inputRightX = 0;

    /**
     * Ramp Constants
     */
    int Dpad = -1;
    /**
     * Ramp up Constant
     */
    // private static final double RAMP_UP     = 0.05;

    // /**
    //  * Ramp down Constant
    //  */
    // private static final double RAMP_DOWN   = 0.05;

    // /**
    //  * Delta Limit
    //  */
    // private static final double DELTA_LIMIT = 0.075;

    /**
     * Constructor
     */
    public Drive(Training train, OI oi)
    {
        m_train = train;
        m_oi = oi;
        addRequirements(m_train); //add the traning subsystem as a requirement 
    }

    /**
     * Code here will run once when the command is called for the first time
     */
    @Override
    public void initialize()
    {

    }

    /**
     * Code here will run continously every robot loop until the command is stopped
     */
    @Override
    public void execute()
    {
        Dpad = m_oi.getDPad();
        /**
         * Get Joystick data
         */
        inputLeftX = m_oi.getLeftDriveX();
        inputLeftY = m_oi.getLeftDriveY();
        inputRightX = m_oi.getRightDriveX();
        inputRightY = m_oi.getRightDriveY(); 

        Right = (-inputLeftX/2)+(-inputLeftY/4)+(-inputRightX/2);
        Left = (inputLeftX/2)+(-inputLeftY/4)+(-inputRightX/2);
        Back = (0)+(inputLeftY/2)+(-inputRightX/2);
        // Lift = (inputRightX/2) + (inputRightY/2) + (-inputRightX/2);
        Lift =  (inputRightY/2);

        m_train.setRightMotorSpeed(Right);
        m_train.setLeftMotorSpeed(Left);
        m_train.setBackMotorSpeed(Back);
        m_train.setLiftMotorSpeed(Lift);
        
        if (Dpad == 0)
        {
            m_train.setServoSpeed(0.3);
        }
        else if (Dpad == 180)
        {
            m_train.setServoSpeed(-0.3);
        }
        else
        {
            m_train.setServoSpeed(0);
        }


        if (Dpad == 90)
        {
            m_train.setServoHvat(1);
        }
        else if (Dpad == 270)
        {
            m_train.setServoHvat(-1);

        }
        else
        {
            m_train.setServoHvat(0);
        }



        // m_train.setStopped(m_oi.getDriveXButton());
        // m_train.setRunning(m_oi.getDriveBButton());

    }

    /**
     * When the comamnd is stopped or interrupted this code is run
     * <p>
     * Good place to stop motors in case of an error
     */
    @Override
    public void end(boolean interrupted)
    {
        m_train.setRightMotorSpeed(0);
    }

    /**
     * Check to see if command is finished
     */
    @Override
    public boolean isFinished()
    {
        return false;
    }
}