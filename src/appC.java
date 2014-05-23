import java.util.List;


public class appC extends ExprC {
   private ExprC function;
   private List<ExprC> args;
   
   public appC(ExprC function, List<ExprC> args) {
      this.function = function;
      this.args = args;
   }
   
   public ExprC getFunction() {
      return this.function;
   }
   
   public List<ExprC> getArgs() {
      return this.args;
   }
   
   public boolean equals(Object other) {
      boolean functionEqual = this.function.equals(((appC) other).getFunction());
      boolean argsEqual = true;
      
      if (this.args.size() == ((appC) other).getArgs().size()) {
         for (int i = 0; i < this.args.size(); i++) {
            if (!this.args.get(i).equals(((appC) other).getArgs().get(i))) {
               argsEqual = false;
               break;
            }
         }
      }
      else {
         argsEqual = false;
      }
      
      if (functionEqual && argsEqual) {
         return true;
      }
      
      return false;
   }
}
