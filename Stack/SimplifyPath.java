package Stack;
import java.util.*;
public class SimplifyPath {

    public static String solution(String path){
        Stack<String> s = new Stack<>();
        String[] dirs = path.split("/");
        for(String dir: dirs){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }else if(dir.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }else{
                s.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : s){
            sb.append("/").append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(solution(path));
    }
}
