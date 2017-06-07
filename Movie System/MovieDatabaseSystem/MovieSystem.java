import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.NumberFormatException;
/**
 * A program that implements a simple Movie Database System. 
 * It aim to keep a database of the movies for a users and to perform operations
 * such as searching for movies, adding/deleting movies, displaying the details 
 * of movies.
 * 
 * This class uses an object of class MovieList to read input, write output
 * about the movie information and an object of class Movie represents each
 * movie in the Movie Database System
 * @author Han Zhong 28154258
 * @version 2017.05.25
 */
public class MovieSystem
{
    private MovieList movieList;
    
    public MovieSystem()
    {
        movieList = new MovieList();
    }
    
    /**
     * This method is the main method to achieve the function
     * of this program. It also uses many methods MovieList class
     */
    public void strat() 
    {
        movieList.readFile();
        String input = "0";   //assign initial value to the input
        while (!input.equals("5"))
        {
            display();
            Scanner option = new Scanner(System.in);
            input = option.nextLine().trim();
            switch (input)
            {
                case "1":
                search();   
                break;
                case "2":
                add();
                break;
                case "3":
                delete();
                break;
                case "4":
                like();
                break;
                case "5":
                System.out.println("System is exited");
                break;
                default:
                System.out.println("Input option must be from 1 to 5");
                break;            
            }
        }
        movieList.writeFile();
        System.exit(0);
    }
    
    private void search() //aim to let the user to type name for searching
    {
        System.out.println("Type movie name you wish to search for:");
        Scanner type = new Scanner(System.in);           
        String title = type.nextLine();  
        boolean result = movieList.searchMovie(title);     
        if (result)
        {   
            System.out.println("---------------------------");
            System.out.println("This operation succeeds !!");
        }
        else 
        {
            System.out.println("---------------------------");
            System.out.println("This operation fails !!");
        }
    }
    
    private void add() //aim to let the user to type the attribute of the movie to add movie 
    {
        Scanner type = new Scanner(System.in);
        System.out.println("Add title:");
        String newTitle = type.nextLine().trim();
        while (newTitle.trim().length() == 0 || newTitle.contains(","))
        {
           System.out.println("Title must not be blank or contains ,");
           System.out.println("Add title:");
           newTitle = type.nextLine().trim();
        } 
        System.out.println("Add director:");
        String newDirector = type.nextLine().trim();        
        while (newDirector.trim().length() == 0 || newDirector.contains(","))
        {
           System.out.println("Director must not be blank or contains ,");
           System.out.println("Add director:");
           newDirector = type.nextLine().trim();
        }        
        List<String> actor1 = new ArrayList<String>();
        System.out.println("Add actor1:");
        String newActor1 = type.nextLine().trim();        
        while (newActor1.trim().length() == 0 || newActor1.contains(","))
        {
           System.out.println("Actor1 must not be blank or contains ,");
           System.out.println("Add Actor1:");
           newActor1 = type.nextLine().trim();
        }            
        System.out.println("Add actor2:");
        String newActor2 = type.nextLine().trim();
        while (newActor2.contains(","))
        {
           System.out.println("Actor2 must not contains ,");
           System.out.println("Add Actor2:");
           newActor2 = type.nextLine().trim();
        }          
        if (newActor2.trim().length() == 0)
        {
           actor1.add(newActor1);
           actor1.add(newActor2); 
           actor1.add("");
        }
        else 
        {
           System.out.println("Add actor3:");
           String newActor3 = type.nextLine().trim();
           while (newActor3.contains(","))
           {
               System.out.println("Actor3 must not contains ,");
               System.out.println("Add Actor3:");
               newActor3 = type.nextLine().trim();
           }
           actor1.add(newActor1);
           actor1.add(newActor2);
           actor1.add(newActor3);
        }
        System.out.println("Add rating:");
        String newRating = type.nextLine().trim();              
        int mark;
        try
        {
            mark = Integer.parseInt(newRating);
            if (mark < 1 || mark > 10)
            {
                System.out.println("Rating must from 1 to 10");
                return;
            }
        }catch(NumberFormatException e)
        {
            System.out.println("Rating must be a number");
            return;
        } 
        Movie movie = new Movie();
        movie.setTitle(newTitle);
        movie.setDirector(newDirector);
        movie.setActor(actor1);
        movie.setRating(mark);
        if(movieList.addMovie(movie))
        {
            System.out.println("---------------------------");
            System.out.println("This operation succeeds !!");
        }
        else
        {
            System.out.println("---------------------------");
            System.out.println("This operation fails !!");
        }
    }
    
    private void delete() //aim to let the user type a name for deleting
    {
        System.out.println("Input a movie title to delete");
        Scanner type = new Scanner(System.in);
        String a = type.nextLine();
        if(movieList.removeMovie(a))
        {
            System.out.println("---------------------------");
            System.out.println("This operation succeeds !!");
        }
        else
        {
            System.out.println("---------------------------");
            System.out.println("This operation fails !!");
        }
    }
    
    private void like() //aim to let the user type a rating for listing
    {
        System.out.println("input a rating from 1 to 10:");
        Scanner type = new Scanner(System.in);        
        String rating = type.nextLine();       
        if(movieList.likeMovie(rating))
        {
            System.out.println("---------------------------");
            System.out.println("This operation succeeds !!");
        }
        else
        {
            System.out.println("---------------------------");
            System.out.println("This operation fails !!");
        }
    }
    
    public void display() //display the main menu
    {
        System.out.println("");
        System.out.println("Welcome to Movie Database System");
        System.out.println("================================");
        System.out.println("(1) Search Movies");
        System.out.println("(2) Add Movie");
        System.out.println("(3) Delete Movie");
        System.out.println("(4) Display Favourite Movies");
        System.out.println("(5) Exit System");
        System.out.println("Choosen an option :");
    }
}
