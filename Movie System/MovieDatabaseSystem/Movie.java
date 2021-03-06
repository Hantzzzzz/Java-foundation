import java.util.List;
import java.util.ArrayList;
/**
 * This is the movie class. It has a title, director, actor and rating.
 * 
 * @author Han Zhong 
 * @version 2017-05-02
 */
public class Movie
{
   private String title;
   private String director;
   private List<String> actor;
   private int rating;
   
   /**
    * constructor with default value
    */
   public Movie()
   {
       title = "";
       director = "";
       actor = new ArrayList<>();
       rating = 1;
    }
   
   /**
    * 
    * constructor
    * @param newTitle A title
    * @param newDirector A director
    * @param newActor A set of actors entered by the users
    * @param newRating A rating
    */  
   public Movie(String newTitle, String newDirector, List<String> newActor, int newRating) 
   {
       if (newTitle.trim().length() != 0)
            title = newTitle;
       else
            title = "NoTitle";
       if (newDirector.trim().length() != 0)
            director = newDirector;
       else
            director = "NoDirector";
       actor = newActor;
       if (newRating > 0 && newRating < 11)
            rating = newRating;
       else
            rating = 0;
   }
    
   public void setTitle(String title) //this method's function is to set a movie title
   {
       if (title.trim().length() != 0)
            this.title = title;
       else
            this.title = "NoTitle";
   }
    
   public void setDirector(String director) // this method's function is to set a movie director
   {
       if (director.trim().length() != 0)
            this.director = director;
       else
            this.director = "NoDirector";  
   }
    
   public void setRating(int rating) // this method's function is to set a movie rating
   {
       if (rating > 0 && rating < 11)
            this.rating = rating;
       else
            this.rating = 0;
   }
   
   public void setActor(List<String> actor) // this method's function is to set a set of actor
   {
       this.actor = actor;      
   }
   
   public String getTitle() //return title value
   {
       return title;
   }
    
   public String getDirector() //return director value
   {
       return director;
   }
    
   public int getRating() //return rating value
   {
       return rating;
   }
    
   public List<String> getActor() //return actor value
   {
       return actor;
   }
      
   public void display() //for testing movie class, display the value
   {
       System.out.println(title + "," + director + "," + actor.get(0) + "," + actor.get(1) + "," + actor.get(2) + "," + rating);
   }
}
