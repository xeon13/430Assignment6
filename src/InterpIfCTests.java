import static org.junit.Assert.*;

import org.junit.Test;


public class InterpIfCTests {

   @Test
   public void test() {
      Driver d = new Driver();

      try {
         assertEquals(d.interp(new ifC(new boolC("true"), new numC(1), new numC(0)), new Environment()), new numV(1));
         assertEquals(d.interp(new ifC(new boolC("false"), new numC(1), new numC(0)), new Environment()), new numV(0));
         assertEquals(d.interp(new ifC(new binopC("<=", new numC(1), new numC(2)), new boolC("true"), new boolC("false")), new Environment()), new boolV("true"));
         assertEquals(d.interp(new ifC(new binopC("<=", new numC(1), new numC(-1)), new boolC("true"), new boolC("false")), new Environment()), new boolV("false"));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}