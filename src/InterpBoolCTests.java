import static org.junit.Assert.*;

import org.junit.Test;


public class InterpBoolCTests {

   @Test
   public void test() {
      Driver d = new Driver();

      try {
         assertEquals(d.interp(new boolC("true"), new Environment()), new boolV("true"));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
