import static org.junit.Assert.*;

import org.junit.Test;


public class InterpIfCCTests {

   @Test
   public void test() {
      Driver d = new Driver();

      try {
         assertEquals(d.interp(new ifC(boolC("true"), numC(1), numC(0)), new Environment()), new numV(1));
         assertEquals(d.interp(new ifC(boolC("false"), numC(1), numC(0)), new Environment()), new numV(0));
         assertEquals(d.interp(new ifC(binopC("<=", numC(1), numC(2)), boolC("true"), boolC("false")), new Environment()), new boolV("true"));
         assertEquals(d.interp(new ifC(binopC("<=", numC(1), numC(-1)), boolC("true"), boolC("false")), new Environment()), new boolV("false"));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}