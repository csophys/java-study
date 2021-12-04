package base.niukewang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringTranfer {

    public static void main(String[] args) {
        System.out.println(trans("hello World", 11));
    }

    public static String trans(String s, int n) {
        // write code here
        //使用栈数据结构存储
        char[] toCharArray = s.toCharArray();
        Stack<List> stack = new Stack<List>();
        for(int i=0;i<n;i++){
            if(i==0||toCharArray[i]==' '){
                List<Character> token = new ArrayList<Character>();
                stack.push(token);
            }
            if(toCharArray[i]!=' '){
                if(toCharArray[i]>='a'){
                    toCharArray[i]=(char)(toCharArray[i]-'a'+'A');
                }else{
                    toCharArray[i]=(char)(toCharArray[i]+'a'-'A');
                }
                List list = stack.pop();
                list.add(toCharArray[i]);
                stack.push(list);
            }

        }
        String result = "";
        while (stack.size()>0){
            if(result!=null){
                result += " ";
            }
            result += stack.pop();
        }
        return result;
    }
}

