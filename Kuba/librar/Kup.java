package librar;

public class Kup {
    int[] state=new int[20];    
    int[] before=new int[20];
    int heuristic=0;
    int step=0;
    int cum_move=0;
    int go_move=0;
    public Kup(int[] state,int heuristic,int step,int cum_move,int go_move){
        this.state=state;
        this.heuristic=heuristic;
        this.step=step;
        this.cum_move=cum_move;
        this.go_move=go_move;
    }
    public Kup(int[] state,int[] before,int heuristic,int step,int cum_move,int go_move){
        this.state=state;
        this.before=before;
        this.heuristic=heuristic;
        this.step=step;
        this.cum_move=cum_move;
        this.go_move=go_move;
    }
    public Kup(int[] state,int cum_move){
        this.state=state;
        this.cum_move=cum_move;
    }
    public int[] getState(){
        return this.state;
    }
    public int[] getBefore(){
        return this.before;
    }
    public int getHeuristic(){
        return this.heuristic;
    }
    public int getStep(){
        return this.step;
    }
    public int getCumMove(){
        return this.cum_move;
    }
    public int getGoMove(){
        return this.go_move;
    }
    public void setGoMove(int go_move){
        this.go_move=go_move;
    }
}
