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
   
   public boolean equals(Object other) {
      boolean argsEqual = true;
      boolean bodyEqual = this.body.equals(((closV) other).getBody());
      boolean envEqual = this.env.equals(((closV) other).getEnv());
      
      if (this.args.size() == ((closV) other).getArgs().size()) {
         for (int i = 0; i < this.args.size(); i++) {
            if (!this.args.get(i).equals(((closV) other).getArgs().get(i))) {
               argsEqual = false;
               break;
            }
         }
      }
      else {
         argsEqual = false;
      }
      
      if(argsEqual && bodyEqual && envEqual) {
         return true;
      }
      else {
         return false;
      }
   }
}
