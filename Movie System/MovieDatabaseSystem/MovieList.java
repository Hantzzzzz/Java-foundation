import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
/**
 * The MovieList class represents a movieList object to store a list of  movie. 
 * It contains the methods to provides several functions of the MovieSystem.
 * addMovie,removeMovie,searchMovie,likeMovvie
 * 
 * The writeFile and readFile methods is an input and ouput mehods to record 
 * the data value into a txt file as a database.
 * @author Han Zhong 
 * @version 2017-05-25
 */
public class MovieList
{
   private List<Movie> movieList; 
    
   public MovieList() //constructor
   {
       movieList = new ArrayList<Movie>();
   }
   /** 
     * addMovie method for adding movie into the MovieSystem
     * @return true or false      
     */ 
   public boolean addMovie(Movie movie)
   {
       for (int i = 0; i < movieList.size(); i++)
        {
            if(movieList.get(i).getTitle().trim().equals(movie.getTitle().trim()))
            {
                System.out.println(movie.getTitle().trim() + " is alread exist");
                return false;
            }
        }
       movieList.add(movie);
       return true;
   }
   
   /** 
    * removeMovie method for deleting movie from the MovieSystem
    * @return true or false      
    */ 
   public boolean removeMovie(String title)
   {      
        Iterator<Movie> it = movieList.iterator();
        int movieSize = movieList.size();
        while (it.hasNext())
        {
            Movie mv = it.next();
            if (title.equals(mv.getTitle()))
            {
                it.remove();
            }                
        }
        if (movieSize == movieList.size())
        {
            System.out.println(title +" is not exist in the movie system ");
            return false;
        }
        return true;
   }
   
   /** 
    * searchMovie method for searching movie in the MovieSystem 
    * @return true or false      
    */ 
   public boolean searchMovie(String title)
   {
       int input = title.trim().length();
       boolean find = false;
       if (input == 0)
       {
            System.out.println("please input a movie title");
            return false;  
       }  
       for (Movie movie : movieList)
       {   
            if ((movie.getTitle().toUpperCase()).contains(title.toUpperCase()))
            {   
                String actor1 = movie.getActor().get(0);
                String actor2 = movie.getActor().get(1);
                String actor3 = movie.getActor().get(2);
                System.out.println(movie.getTitle()+ "," + movie.getDirector() + "," + actor1 + "," + actor2 + "," + actor3 + "," + movie.getRating());
                find = true;
            }
       }
       if (!find) 
       {
           System.out.println("No match movies in the movie system");
           return false;
       }
       return true; 
   }
   
   /** 
    * removeMovie method for listing a list of movie from the MovieSystem
    * @return true or false      
    */ 
   public boolean likeMovie(String rating)
   {  
      try
      {
       for (Movie movie : movieList)
       {
           int mark = movie.getRating();
           int mark2 = Integer.parseInt(rating);
           if (mark2 < 1 || mark2 > 10)
           {
               System.out.println("Input rating value must from 1 to 10");
               return false;
           }
           if (mark >= mark2)
           {
               String actor1 = movie.getActor().get(0);
               String actor2 = movie.getActor().get(1);
               String actor3 = movie.getActor().get(2);
               System.out.println(movie.getTitle()+ "," + movie.getDirector() + "," + actor1 + "," + actor2 + "," + actor3 + "," + movie.getRating());
           }
       }
      }catch(NumberFormatException e)
      {
          System.out.println("input is not a valid number");
          return false;
      }
       return true;
   }
   
   /** 
    * Ouput the value to a txt file 
    */ 
   public void writeFile()
   {
        File file = new File("myvideos.txt");
        try
        {
            PrintWriter printWriter = new PrintWriter(file);
            for (int i = 0; i < movieList.size(); i++)
            {
                String title = movieList.get(i).getTitle();
                String director = movieList.get(i).getDirector();
                List<String> actor = movieList.get(i).getActor();
                int rating = movieList.get(i).getRating();
                printWriter.println(title + "," + director + "," + actor.get(0) + "," + actor.get(1)+ "," + actor.get(2)+ "," + rating);
            }
            printWriter.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("File is not found");
        }
        movieList.clear();
   }
   
   /** 
    * input the value from a txt file 
    */    
   public void readFile()
   {
        try
        {
            String fileName = "myvideos.txt";
            FileReader fileReader = new FileReader(fileName);
            Scanner parser = new Scanner(fileReader);
            while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                String[] stringArray = line.split(",");
                Movie movie = new Movie();
                movie.setTitle(stringArray[0]);
                movie.setDirector(stringArray[1]);
                List<String> actor = new ArrayList<String>();
                actor.add(stringArray[2]);
                actor.add(stringArray[3]);
                actor.add(stringArray[4]);
                movie.setActor(actor);  
                int rating = Integer.parseInt(stringArray[5]);
                movie.setRating(rating);
                movieList.add(movie);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File is not found");
        }
   }
}


