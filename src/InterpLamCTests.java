import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class InterpLamCTests {

   @Test
   public void test() {
      Driver d = new Driver();
      Environment env = new Environment();
      List<String> args = new LinkedList<String>();
      args.add("x");
      
      try {
         assertEquals(d.interp(new lamC(args, new numC(7)), env), new closV(args, new numC(7), env));
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
