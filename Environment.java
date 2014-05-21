import java.util.HashMap;


public class Environment {
   private HashMap<String, Value> env;
   
   public Environment() {
      env = new HashMap<String, Value>();
   }
   
   public Environment(Environment base) {
      env = base.getHash();
   }
   
   public HashMap<String, Value> getHash() {
      return this.env;
   }
   
   public void add(String s, Value v) {
      env.put(s, v);
   }
   
   public Value lookup(String s) {
      return env.get(s);
   }
}
