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
}
