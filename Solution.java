import java.util.*;

public class Solution 
{
    public static void main(String[] args) 
    {
       String a = "><><<<>";
       System.out.println(makeItBalanced(a));
    }
    
    
    public static String makeItBalanced(String brackets)
    {
       StringBuilder sb = new StringBuilder();
       int leftCount = 0;
       int rightCount = 0; 
       ArrayDeque<Character> stack = new ArrayDeque<>();
       for( int i=0; i<=brackets.length()-1; i++)
       {
           char ch = brackets.charAt(i);
           if(ch=='<')  stack.push('<');
           else if(ch=='>')
           {
              if(stack.size()==0)  stack.push(ch);
              else 
              {
                 char preCh = stack.peek();
                 if(preCh=='<')  stack.pop();
                 else stack.push(ch);
              }
           } 
           else throw new RuntimeException("InputError");
       }
       while(stack.size()>0)
       {
           char ch = stack.pop();
           if(ch=='<')  leftCount++;
           else rightCount++;    
       }
       for( int i=0; i<=rightCount-1; i++)
           sb.append("<");
       sb.append(brackets);
       for( int i=0; i<=leftCount-1; i++)
           sb.append(">");
       return sb.toString();  
    }
}
