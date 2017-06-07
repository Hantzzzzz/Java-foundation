import java.util.Scanner;
/**
 * The dice class is aim to generate a randam number.
 * 
 * @author HanZhong 28154258 
 * @version (2017.04.09)
 */
public class Dice
{  
    private int diceValue;

    public Dice()  //cpnstructor
    {
        diceValue = 0;
    }

    public Dice(int newDiceValue)  //constructor
    {
        diceValue = newDiceValue;
    }

    public int getDiceValue()  //This method's function is to get a random number.
    {
        diceValue = (int)(Math.random() * 6) + 1;
        return diceValue;
    }

    public void addNumbers()
    {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int number = 0;
        do
        {
            System.out.println("Enter a number (-99 to stop):");
            number = input.nextInt();
            if (number != -99)
                total = total + number;
        } while (number != -99);
        System.out.println(total);
    }
    
    public void temp()
    {
        Scanner tem = new Scanner(System.in);
        int a = 0;
        int avg = 0;
        int sum = 0;
        do{
            System.out.println("input");
            a = tem.nextInt();
            int i = 1;
            sum = sum + a;
            avg = sum / i;
            i++;
        }
        while(a != -99);
        System.out.println(avg);
    
    }
}

