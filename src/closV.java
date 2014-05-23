import java.util.List;


public class closV extends Value {
   private List<String> args;
   private ExprC body;
   private Environment env;
   
   public closV(List<String> args, ExprC body, Environment env) {
      this.args = args;
      this.body = body;
      this.env = env;
   }
   
   public String toString() {
      return "#<procedure>";
   }
   
   public List<String> getArgs() {
      return this.args;
   }
   
   public ExprC getBody() {
      return this.body;
   }
   
   public Environment getEnv() {
      return this.env;
   }
}
