import static org.junit.Assert.*;

import org.junit.Test;


public class InterpNumCTests {

   @Test
   public void test() {
      Driver d = new Driver();
      
      try {
         assertEquals(d.interp(new numC(3), new Environment()), new numV(3));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
