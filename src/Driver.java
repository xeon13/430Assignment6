import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Driver {
   static ArrayList<String> patternList = new ArrayList<String>();
   
   private static void patternInit() {
      patternList.add("true");                   //true
      patternList.add("false");                  //false
      patternList.add("\\w");                    //id
      patternList.add("if \\{*\\p{Print}*}* \\{*\\p{Print}*}* \\{*\\p{Print}*}*");         //if
      patternList.add("with [\\w = \\{*\\p{Print}*}*]* \\{*\\p{Print}*}*");  //with
      patternList.add("\\+ \\{*\\p{Print}*}* \\{*\\p{Print}*}*");    //add
      patternList.add("\\- \\{*\\p{Print}*}* \\{*\\p{Print}*}*");            //minus
      patternList.add("\\* \\{*\\p{Print}*}* \\{*\\p{Print}*}*");            //mult
      patternList.add("\\/ \\{*\\p{Print}*}* \\{*\\p{Print}*}*");            //divide
      patternList.add("eq\\? \\{*\\p{Print}*}* \\{*\\p{Print}*}*");          //eq?
      patternList.add("\\<= \\{*\\p{Print}*}* \\{*\\p{Print}*}*");           //<=
      patternList.add("fn [\\w*] \\w");          //fn
      patternList.add("\\w \\w*");               //appc
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      patternInit();
      parse("true");
      parse("false");
      parse("+ {+ 1 2} 2");
   }
   
   private static ExprC parse(String expr) {
      Pattern pat;
      Matcher mat;
      int pattern = -1;
      for (int i = 0; i < patternList.size(); i++) {
          pat = Pattern.compile(patternList.get(i));
          mat = pat.matcher(expr);
          if (mat.matches()) {
              pattern = i;
              break;
          }
      }
      
      ArrayList<String> params = new ArrayList<String>();
      ArrayList<ExprC> args = new ArrayList<ExprC>();
      
      switch (pattern) {
          case 0: //true
              System.out.println("True");
              return new boolC("true");
          case 1: //false
              System.out.println("False");
              return new boolC("false"); 
          case 2: //id
              return new idC("Not done");
          case 3: //if
              return new ifC(new boolC("true"), new boolC("true"), new boolC("false"));
          case 4: //with
              return new appC(new lamC(params, new numC(1)), args);
          case 5: //+
              System.out.println("Adding");
              return new binopC("+", new numC(1), new numC(1));
          case 6: //-
              return new binopC("-", new numC(1), new numC(1));
          case 7: //*
              return new binopC("*", new numC(1), new numC(1));
          case 8: // /
              return new binopC("/", new numC(1), new numC(1));
          case 9: //eq?
              return new binopC("eq?", new numC(1), new numC(1));
          case 10: //<=
              return new binopC("<=", new numC(1), new numC(1));
          case 11: //fn
              return new lamC(params, new numC(1));
          case 12: //app
              return new appC(new numC(1), args);
      }
      System.out.println("Returning null");
      return null;
   }
   
   private Value interp(ExprC e, Environment env) throws InvalidValueException {
      if (e instanceof numC) {
         return new numV(((numC) e).getNumber());
      }
      else if (e instanceof boolC) {
         return new boolV(((boolC) e).getCase());
      }
      else if (e instanceof lamC) {
         return new closV(((lamC) e).getParams(), ((lamC) e).getBody(), env);
      }
      else if (e instanceof appC) {
         ExprC appFunction = ((appC) e).getFunction();
         List<ExprC> appArgs = ((appC) e).getArgs();
         
         Value fValue = interp(appFunction, env);
         List<Value> interpedArgs = interpArgs(appArgs, env);
         
         if (fValue instanceof closV) {
            Environment filledEnv = fillEnv(((closV) fValue).getArgs(), interpedArgs, ((closV) fValue).getEnv());
            return interp(((closV) fValue).getBody(), filledEnv);
         }
         else {
            throw new InvalidValueException();
         }
      }
      else if (e instanceof binopC) {
          return binopDecider(e.getOpName(), interp(e.getLeft() env), interp(e.getRight()));
      }
      
      return null;
   }
   
   private Value binopDecider(String op, Value l, Value r) {
       if (op.equals("+")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               return new numV(l.getNumber() + r.getNumber());
           }
           else {
               throw new NotNumberException();
           }
       }
       else if (op.equals("-")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               return new numV(l.getNumber() - r.getNumber());
           }
           else {
               throw new NotNumberException();
           }
       }
       else if (op.equals("*")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               return new numV(l.getNumber() * r.getNumber());
           }
           else {
               throw new NotNumberException();
           }
       }
       else if (op.equals("/")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               return new numV(l.getNumber() / r.getNumber());
           }
           else {
               throw new NotNumberException();
           }
       }
       else if (op.equals("<=")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               if (l.getNumber() <= r.getNumber()) {
                   return new boolV("true");
               }
               else {
                   return new boolV("false");
               }
           }
           else {
               throw new NotNumberException();
           }
       }
       else if (op.equals("eq?")) {
           if ((l instanceof numV) && (r instanceof numV)) {
               if (l.getNumber().equals(r.getNumber())) {
                   return new boolV("true");
               }
               else {
                   return new boolV("false");
               }
           }
           else if ((l instanceof boolV) && (r instanceof boolV)) {
               if (l.equals(r)) {
                   return new boolV("true");
               }
               else {
                   return new boolV("false");
               }
           }
           else {
               throw new NotNumberException();
           }
       }
       else {
           return new boolV("false");
       }
   }
   
   private List<Value> interpArgs(List<ExprC> args, Environment env) {
      List<Value> toReturn = new ArrayList<Value>();
      
      for (ExprC arg : args) {
         try {
            toReturn.add(interp(arg, env));
         } 
         catch (InvalidValueException e) {
            e.printStackTrace();
         }
      }
      
      return toReturn;
   }
   
   private Environment fillEnv(List<String> params, List<Value> args, Environment initialEnv) throws IndexOutOfBoundsException {
      Environment newEnv = new Environment(initialEnv);
      
      if (params.size() != args.size()) {
         throw new IndexOutOfBoundsException();
      }
      
      for (int i = 0; i < params.size(); i++) {
         newEnv.add(params.get(i), args.get(i));
      }
      
      return newEnv;
   }

   private String serialize(Value v) {
      return v.toString();
   }
   
   private String topEval(String expr) {
      try {
         return serialize(interp(parse(expr), new Environment()));
      } 
      catch (InvalidValueException e) {
         e.printStackTrace();
      }
      
      return null;
   }
}
