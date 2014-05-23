import static org.junit.Assert.*;

import org.junit.Test;


public class InterpIdCTests {

   @Test
   public void test() {
      Driver d = new Driver();
      Environment env = new Environment();
      env.add("x", new numV(7));
      
      try {
         assertEquals(d.interp(new idC("x"), env), new numV(7));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
