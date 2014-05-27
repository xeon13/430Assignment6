import static org.junit.Assert.*;

import org.junit.Test;


public class InterpBinopCTests {

   @Test
   public void test() {
      Driver d = new Driver();

      try {
         assertEquals(d.interp(new binopC("+", new numC(1), new numC(14)), new Environment()), new numV(15));
         assertEquals(d.interp(new binopC("-", new numC(20), new numC(14)), new Environment()), new numV(6));
         assertEquals(d.interp(new binopC("/", new numC(4), new numC(2)), new Environment()), new numV(2));
         assertEquals(d.interp(new binopC("*", new numC(6), new numC(6)), new Environment()), new numV(36));
         assertEquals(d.interp(new binopC("<=", new numC(1), new numC(14)), new Environment()), new boolV("true"));
         assertEquals(d.interp(new binopC("<=", new numC(1), new numC(0)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", new numC(1), new numC(14)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", new boolC("true"), new boolC("false")), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", new boolC("false"), new numC(14)), new Environment()), new boolV("false"));
         assertEquals(d.interp(new binopC("eq?", new boolC("true"), new boolC("true")), new Environment()), new boolV("true"));
         assertEquals(d.interp(new binopC("eq?", new numC(14), new numC(14)), new Environment()), new boolV("true"));
      } 
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}