package GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成（中等）
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

/**已经想到关键是左括号必须多于右括号，惭愧，看了攻略才想到递归*****************************/
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne("",list,n,n);
        return list;
    }

    public void generateOneByOne(String subList, List<String> list, int left, int right){
        /***左括号必须多于右括号*/
        if(left > right){
            return ;
        }
        if(left > 0){
            generateOneByOne(subList+"(",list,left-1,right);
        }
        if(right > 0){
            generateOneByOne(subList+")",list,left,right-1);
        }
        if(left == 0 && right == 0){
            list.add(subList);
            return ;
        }

    }

    public static void main(String[] args){
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        int n = 4 ;
        List<String> list = generateParenthesis.generateParenthesis(4);
        System.out.println(list);
    }
}
