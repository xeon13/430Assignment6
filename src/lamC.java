import java.util.List;


public class lamC extends ExprC {
   private List<String> params;
   private ExprC body;
   
   public lamC(List<String> params, ExprC body) {
      this.params = params;
      this.body = body;
   }
   
   public List<String> getParams() {
      return this.params;
   }
   
   public ExprC getBody() {
      return this.body;
   }
   
   public boolean equals(lamC other) {
      boolean paramsEqual = true;
      boolean bodyEqual = this.body.equals(other.body);
      
      if (this.params.size() == other.getParams().size()) {
         for (int i = 0; i < this.params.size(); i++) {
            if (!this.params.get(i).equals(other.getParams().get(i))) {
               paramsEqual = false;
               break;
            }
         }
      }
      else {
         paramsEqual = false;
      }
      
      return paramsEqual && bodyEqual;
   }
}
