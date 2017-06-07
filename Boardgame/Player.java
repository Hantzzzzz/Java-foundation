
/**
 * Class player is aim to keep player name and position value call for the game
 * class. 
 * @author Han Zhong 28154258 
 * @version 2017.04.09
 */

public class Player
{
    private String name;
    private int position;
    
    public Player()   //constructor
    {
       this.position = 0;
       this.name = "default";
    }
    
    public Player(String newName,
                    int newPosition)   //constructor
    {
       this.position = newPosition;
       this.name = newName;
    }
    
    public void setPosition(int position)  //this method's function is to keep position value.
    {
       this.position = position;
    }
    
    public void setName (String name)  //this method is used to keep the input name.
    {
        this.name = name;
    }
    
    public int getPosition(){     //this method is to turn out position value
        return this.position;
    }
    
    public String getName(){      //this method is to turn out name value
        return this.name;
    }    
}
