import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class RegisterBookGUITest {

    private String mDriver;
    private String mUrl;
    private String mUser;
    private String mPassword;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mDriver = "org.h2.Driver";
        mUrl = "jdbc:h2:~/ngesumin;IFEXISTS=TRUE";
        mUser = "brayo";
        mPassword = "brayo";
    }
@Test
void registerBook() {
    String weka = "INSERT into books values(java for dummies, tutorial, brian , 123456 , 2020 )";
    try {
        Class.forName(mDriver);
        Connection conn = DriverManager.getConnection(mUrl, mUser, mPassword);
        PreparedStatement addNewBook = conn.prepareStatement(weka);

        addNewBook.executeUpdate();

//        String BookTitle = "java for dummies";
//        String BookType = "tutorial";
//        String Author = "brian";
//        String SerialNumber = "123456";
//        String Year = "2020";

    }
    catch (Exception ex) {
        ex.printStackTrace();
    }

}
    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }
}