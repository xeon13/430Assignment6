import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class InterpAppCTests {

   @Test
   public void test() {
      Driver d = new Driver();
      Environment env = new Environment();
      List<String> args = new LinkedList<String>();
      args.add("x");
      List<ExprC> params = new LinkedList<ExprC>();
      params.add(new numC(5));
      
      try {
         assertEquals(d.interp(new appC(new lamC(args, new idC("x")), params), env),
               (new numV(5)));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
