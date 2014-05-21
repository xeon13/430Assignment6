
public class Driver {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   
   private ExprC parse(String expr) {
      return null;
   }
   
   private Value interp(ExprC e, Environment env) {
      return null;
   }

   private String serialize(Value v) {
      return null;
   }
   
   private String topEval(String expr) {
      return serialize(interp(parse(expr), new Environment()));
   }
}
