import static org.junit.Assert.*;

import org.junit.Test;


public class InterpBinopCTests {

   @Test
   public void test() {
      Driver d = new Driver();

      try {
         assertEquals(d.interp(new binopC("+", numC(1), numC(14)), new Environment()), new numV(15));
         assertEquals(d.interp(new binopC("-", numC(20), numC(14)), new Environment()), new numV(6));
         assertEquals(d.interp(new binopC("/", numC(4), numC(2)), new Environment()), new numV(2));
         assertEquals(d.interp(new binopC("*", numC(6), numC(6)), new Environment()), new numV(36));
         assertEquals(d.interp(new binopC("<=", numC(1), numC(14)), new Environment()), new boolV("true"));
         assertEquals(d.interp(new binopC("<=", numC(1), numC(0)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", numC(1), numC(14)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", boolC("true"), boolC("false")), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", boolC("false"), numC(14)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", boolC("true"), boolC("true")), new Environment()), new boolV("true"));
         assertEquals(d.interp(new binopC("eq?", numC(14), numC(14)), new Environment()), new boolV("true"));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}