
import java.util.Scanner;

/**
 * A program that plays a rather simplistic Board Game. Two players can
 * be handled by this program.Only a text interface is implemented for this
 * program.It will keep track of the positions of the players until one, or 
 * both reaches a position of 50. If a player reaches the special positions 
 * of 11, 22, 33, or 44, he** will be penalised by having 5 subtracted from 
 * his current position.
 * 
 * @author Han Zhong 28154258
 * @version 2017.04.09
 */
 
public class Game
{
    private Player player1;
    private Player player2; 
    private Dice dice;    //fileds are declare here
    
    /**
     * Constructor for Game objects. This constructor 
     * creates two new player with "Null" name.
     */
    
  	public Game()   // Constructor
    {
        player1 = new Player();
        player2 = new Player();
        dice = new Dice();   
    }
    
    /**
     * This method is the main method to achieve the function
     * of this program. It also uses many methods from Dice and
     * Player.
     */
    public void start()
    {
        String input = "0";   //assign initial value to the input
        while (!"5".equals(input))
        {
            displayMenu();
            Scanner option = new Scanner(System.in);   //Scanner method for entering option.
            input = option.next();   
                switch (input)
                {                    
                    case "1":     //Start/restart game and enter players' name.
                    Scanner typename = new Scanner(System.in);    //Scanner for entering names.
                    player1.setPosition(0);
                    player2.setPosition(0);   //reset two player's position to 0.
                    System.out.println("please enter first player's name:");
                    String player1Name = typename.nextLine().trim();
                    player1.setName(player1Name);
                    System.out.println("please enter second player's name:");
                    String player2Name = typename.nextLine().trim();
                    player2.setName(player2Name);
                    break;   
                    case "2":      //Play One Round
                        /**
                         * The function of this IF statement is to judge whether the
                         * game is over.
                         */
                        int prePosition1 = player1.getPosition();
                     	int prePosition2 = player2.getPosition();
                     	int diceNumber1 = dice.getDiceValue();
                     	int diceNumber2 = dice.getDiceValue();
                        if (player1.getPosition() >= 50 && 
							player2.getPosition() >= 50)  //if the game is finishied, user can't play anymore.
                        {
                            System.out.println("Game finished. You must start a new game");
                            System.out.println("** The last game ended in a draw **");
                            break;
                        }
                        else if (player1.getPosition() >= 50)
                        {
                            System.out.println("Game finished. You must start a new game");
                            System.out.println("The last game was won by player " + player1.getName());
                            break;
                        }
                        else if (player2.getPosition() >= 50)
                        {
                            System.out.println("Game finished. You must start a new game");
                            System.out.println("The last game was won by player " + player2.getName());
                            break;
                        }
                        if (player1.getName().equals("") || 
                            player2.getName().equals("") || 
                            player1.getName().equals("default") ||
						    player2.getName().equals("default"))    //ensure the name has setted up to the player.
                            System.out.println("Error : players have not been set up!");
                        else  
                        {
                            player1.setPosition(prePosition1 + diceNumber1);
                                if (player1.getPosition() == 11 ||
                                    player1.getPosition() == 22 || 
                                    player1.getPosition() == 33 || 
                                    player1.getPosition() == 44) //judge whether the players is on penalty position.
                                {
                                    player1.setPosition(player1.getPosition() - 5);
                                    System.out.println(player1.getName() + " rolled a " + diceNumber1 + " moves from position " + prePosition1 + " to "+ player1.getPosition() + " (penalty) ");
                                }
                                else
                                    System.out.println(player1.getName() + " rolled a " + diceNumber1 + " moves from position " + prePosition1 + " to " + player1.getPosition());
                            player2.setPosition(prePosition2 + diceNumber2);
                                if(player2.getPosition() == 11 || 
                                   player2.getPosition() == 22 || 
                                   player2.getPosition() == 33 || 
                                   player2.getPosition() == 44)
                                {
                                    player2.setPosition(player2.getPosition() - 5);
                                    System.out.println(player2.getName() + " rolled a " + diceNumber2 +" moves from position " + prePosition2 + " to "+ player2.getPosition() + " (penalty) ");
                                }    
                                else
                                    System.out.println(player2.getName() + " rolled a " + diceNumber2 + " moves from position " + prePosition2 + " to " + player2.getPosition());
                          if (player1.getPosition() >= 50 && 
                              player2.getPosition() >= 50)  //break out and display notification if the game is finished
                          {
                              System.out.println("** The game ended in a draw **");
                              break;
                          }
                          else if (player1.getPosition() >= 50)
                          {
                              System.out.println("** Congratulations " + player1.getName() + " has won this game");
                              break;
                           }
                          else if (player2.getPosition() >= 50)
                          {
                              System.out.println("** Congratulations " + player2.getName() + " has won this game");
                              break;
                          }  
                        }
                    break;  
                    case "3":   //Display Players' Positions
                        if (player1.getName().equals("") || 
                            player2.getName().equals("") || 
                            player1.getName().equals("default") || 
                            player2.getName().equals("default"))   //if the player's name has not be setted, the interface will display error message.
                            System.out.println("Error : players have not been set up!");
                        else   //if the player has setted already, the interface will display player's position.
                            System.out.println(player1.getName() + "'s position:" + player1.getPosition() + " ***** "+ player2.getName() + "'s position:"+ player2.getPosition()); 
                    break;  
                    case "4":    //Display Game Help
                     System.out.println("A Simple board game. The number of players for this game is 2 players"); 
                    break; 
                    case "5":     //Exit Game
                    break;  
                    default: 
                    System.out.println("Please enter valid number"); 
                    break; 
                }
        } 
    }      
        
    public void displayMenu()   //the game main menu for displaying
    {
        System.out.println("");
        System.out.println("Welcome to the Simple Board Game");
        System.out.println("================================");
        System.out.println("(1) Start/Restart a Game");
        System.out.println("(2) Play One Round");
        System.out.println("(3) Display Players' Positions");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("Choosen an option :");
    }
}


