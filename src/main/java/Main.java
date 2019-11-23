import util.C3poDataSource;
import util.DataChecker;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        DataChecker checker = new DataChecker();
        checker.checkEmail("cat@lady.com");
        checker.checkEmail("cat.lady@lady.com");
        checker.checkEmail("cat-dragon@lady.com");
        checker.checkEmail("cat----@lady.com");
        checker.checkEmail("catlady.com");
        checker.checkEmail("cat@ladycom");
        checker.checkEmail("cat@.com");
        checker.checkEmail("cat@lady.com");
        checker.checkEmail("@lady.com");
        checker.checkEmail("\'cat----@lady.com");
    }
}
