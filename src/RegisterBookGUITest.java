import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class RegisterBookGUITest extends RegisterBookGUI {

    private String mDriver;
    private String mUrl;
    private String mUser;
    private String mPassword;
        String Book_Title;
        String Book_Type ;
        String Author ;
        String Serial_Number;
        String Year ;
    private String mRead4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mDriver = "org.h2.Driver";
        mUrl = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
        mUser = "brayo";
        mPassword = "brayo";
    }
@Test
void registerBook() throws ClassNotFoundException, SQLException,SQLNonTransientException {
    String insert = "INSERT into books (Book_Title,Author,Serial_Number,Year,Book_Type) values ('java','brian','123456','2020','tutorial' )";
    String read = "SELECT BOOK_TITLE FROM BOOKS WHERE BOOK_TITLE = 'java'";
    String delete = "DELETE FROM BOOKS WHERE BOOK_TITLE = 'java'";

    try {
        Class.forName(mDriver);
        Connection conn = DriverManager.getConnection(mUrl, mUser, mPassword);
        PreparedStatement addNewBook = conn.prepareStatement(insert);
        PreparedStatement readBook = conn.prepareStatement(read);
        PreparedStatement deleteBook = conn.prepareStatement(delete);
        ResultSet rs = readBook.executeQuery();

        addNewBook.executeUpdate();
        readBook.executeQuery();

//        String BookTitle = "java for dummies";
//        String BookType = "tutorial";
//        String Author = "brian";
//        String SerialNumber = "123456";
//        String Year = "2020";
    }
    finally{
        conn.rollback();
        conn.close();
    }


}

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}