import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class testBook {

    Book expectedBook = new Book ("1", "Book1", "Author1", 10);

    @Test
    public void getID(){
        String actualID = "1";
        Assertions.assertEquals(expectedBook.getID(), actualID);
    }

    @Test
    public void getTitle(){
        String actualTitle = "Book1";
        Assertions.assertEquals(expectedBook.getTitle(), actualTitle);
    }

    @Test
    public void getAuthor(){
        String actualAuthor = "Author1";
        Assertions.assertEquals(expectedBook.getAuthor(), actualAuthor);
    }

    @Test
    public void getPages(){
        int actualPages = 10;
        Assertions.assertEquals(expectedBook.getPages(), actualPages);
    }

}
