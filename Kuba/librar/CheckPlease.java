package librar;

public class CheckPlease {
    public static boolean check(int[] state, int[] goal){
        for(int i=0;i<state.length;i++){
            if(state[i]!=goal[i]){
                return false;
            }
        }
        return true;
    }
}
