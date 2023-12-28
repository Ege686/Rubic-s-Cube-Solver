import java.util.ArrayList;
import java.util.List;

import librar.*;
public class idashReverse {
    //1=white 2=green 3=orange 4=blue 5=yellow 6=red
    static int[] cuba={123,183,143,843,543,583,523,823,128,148,548,528,126,186,146,846,546,586,526,826};

    static int[][] next_cubait={{6,2,12},{7,9,1},{0,14,4},{1,3,10},{2,6,16},{3,11,5},{4,18,0},{5,7,8},
                                    {8,1,19},{9,13,3},{10,5,15},{11,17,7},
                                    {14,0,18},{15,8,13},{16,12,2},{17,15,9},{18,4,14},{19,10,17},{12,16,6},{13,19,11}
    };

    static List<Kup> kups=new ArrayList<Kup>();        
    static List<Kup> reacg=new ArrayList<Kup>();    

    
    static List<Kup> endinade=new ArrayList<Kup>();

    static int threshold=0;
    
    static List<Integer> reached=new ArrayList<Integer>();    
    static List<Integer> finished=new ArrayList<Integer>();

    static List<Integer> solusyon=new ArrayList<Integer>();
    static boolean started=false;
    static boolean finn=false;
    public static void do_a_favor(int[] goal,List<Kup> reachs) {
        if(!started){
        kups.add(new Kup(cuba,null, 0, 0, 0, 10));
        //System.out.println(Heuristic.heuristic(kups.get(0).getState(), goal, next_cubait));
        reached.add(threshold);
        started=true;
        }
        Kup top=kups.get(0);
        int cum=top.getGoMove()+1;
        int p=(int)(cum/10)*10;
        for(;p<70;p+=10){
            int s=cum-p;
            cum=p+11;
            if((int)top.getCumMove()/10==(int)p/10)
                continue;
            for(;s<4;s+=1){
                int m=p+s;
                int[] s_t=new int[20];
                Rotate.eshithle(s_t, Rotate.enkripshın(m, top.getState(), next_cubait));
                int h_t=Heuristic.heuristic(s_t, goal, next_cubait);
                h_t+=top.getStep()+1;
                for(int i=0;i<reachs.size();i++){
                    int[] ali=reachs.get(i).getState();
                    finn=CheckPlease.check(s_t,ali);
                    /*
                    int her=Heuristic.heuristic(s_t, ali, next_cubait);
                    if(her<h_t){
                        h_t=her;
                        Rotate.eshithle(goal, ali);
                    }*/
                    if(finn){
                        System.out.println(reachs.size()+" sd");
                        break;
                    }
                }
                Kup t=new Kup(s_t, top.getState(), h_t, top.getStep()+1, m, 10);
                reacg.add(t);
                top.setGoMove(m);
                if(t.getHeuristic()<=threshold){
                    kups.add(0, t);
                    solusyon.add(solusyon.size(),m);
                    p=80;
                    break;
                }
                else{
                    int ia=0;
                    for(int i=0;i<reached.size();i++){
                        if(h_t<reached.get(i))
                            break;
                        ia++;
                    }
                    reached.add(ia,h_t);
                }
                if(finn)
                    break;
            }
            if(finn||p==80)
                break;
        }
        if(p!=80&&!finn){
            if(top.getBefore()!=null){
                kups.remove(0);
                solusyon.remove(solusyon.size()-1);
            }
            else{
                if(top.getGoMove()==63){
                    finished.add(reached.get(0));
                    reached.remove(0);
                    threshold=reached.get(0);
                    reached.clear();
                    reached.add(threshold);   
                    kups.clear();
                    kups.add(new Kup(cuba,null, 0, 0, 0, 10));
                    solusyon.clear();
                    reacg.clear();
                }
            }
        }
    }
}
