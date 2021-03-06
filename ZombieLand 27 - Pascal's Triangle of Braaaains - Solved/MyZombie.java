import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Help Karl collect all of the brains.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyZombie extends UltraZombie
{
    /**
     * Karl's planned out actions to build the triangle of brains in front of him.
     */
    public void plan() 
    {       
       findCenter();
       putBrain();
       
       while (isFrontClear()) {
           move();
       }
       
       turnLeft();
       
       while (isFrontClear()) {
           buildRow();
       }
       
       while (isFacing() != NORTH)
       {
           turnRight();
       }
       
       while (isFrontClear())
       {
           move();
       }
              win();
    }
    
    public void findCenter()
    {
        if (isFrontClear())
        {
            move();
            if (isFrontClear())
            {
                move();
            }
            else
            {
                turnAround();
                return;
            }
        }
        else
        {
            turnAround();
            return;
        }
        findCenter();
        move();
    }
    
    public void buildRow()
    {
        move();
        turnLeft();
        if(!isFrontClear()) 
        {
            turnAround();
        }
        
        addRight();
        move();
        while(isFrontClear())
        {
            addLeft();
            addRight();
            move();
        }
        addLeft();
        
        turnAround();
        
        while(isFrontClear())
        {
            move();
        }
        
        turnLeft();
    }
    
    public void addLeft()
    {
        turnLeft();
        move();
        turnLeft();
        
        // Check if the cell exists
        if (isFrontClear())
        {
            // if so, move into it.
            move();
        }
        else
        {
            // if not, return to the starting cell and exit
            turnLeft();
            move();
            turnLeft();
            return;
        }
        
        turnAround();
        
        // If this was a blank spot, bail
        if (!isBrainHere()) {
            move();
            turnRight();
            move();
            turnLeft();
            return;
        }
        
        // Move this pile to its right
        moveBrains();
        
        // Duplicate the new pile back on the original spot and below
        move();
        turnAround();
        while(isBrainHere())
        {
            takeBrain();
            move();
            putBrain();
            turnAround();
            move();
            turnRight();
            move();
            putBrain();
            turnAround();
            move();
            turnLeft();
        }
                
        // Return to the starting cell
        turnLeft();
        move();
        turnLeft();
    }
    
    public void addRight()
    {
        turnLeft();
        move();
        turnRight();
        
        // Check if the cell exists
        if (isFrontClear())
        {
            // if so, move into it.
            move();
        }
        else
        {
            // if not, return to the starting cell and exit
            turnRight();
            move();
            turnLeft();
            return;
        }
        
        turnAround();
        
        // If this was a blank spot, bail
        if (!isBrainHere()) {
            move();
            turnLeft();
            move();
            turnLeft();
            return;
        }
        
        // Move this pile to its right
        moveBrains();
        
        // Duplicate the new pile back on the original spot and below
        move();
        turnAround();
        while(isBrainHere())
        {
            takeBrain();
            move();
            putBrain();
            turnAround();
            move();
            turnLeft();
            move();
            putBrain();
            turnAround();
            move();
            turnRight();
        }
                
        // Return to the starting cell
        turnRight();
        move();
        turnLeft();
    }
    
    public void moveBrains()
    {
        while (isBrainHere())
        {
            takeBrain();
            move();
            putBrain();
            turnAround();
            move();
            turnAround();
        }
    }
}
