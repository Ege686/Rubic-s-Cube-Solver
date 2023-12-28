import java.util.ArrayList;
import java.util.List;

import librar.*;
public class idash {
    //1=white 2=green 3=orange 4=blue 5=yellow 6=red
    static int[] cuba={123,183,143,843,543,583,523,823,128,148,548,528,126,186,146,846,546,586,526,826};    
    static int[] goal={123,183,143,843,543,583,523,823,128,148,548,528,126,186,146,846,546,586,526,826};    
    static int[] goall={123,183,143,843,543,583,523,823,128,148,548,528,126,186,146,846,546,586,526,826};


    static int[][] next_cubait={{6,2,12},{7,9,1},{0,14,4},{1,3,10},{2,6,16},{3,11,5},{4,18,0},{5,7,8},
                                    {8,1,19},{9,13,3},{10,5,15},{11,17,7},
                                    {14,0,18},{15,8,13},{16,12,2},{17,15,9},{18,4,14},{19,10,17},{12,16,6},{13,19,11}
    };
    static String[] mix={"F2","R2","U","L","D'","B","R2","U","R"};

    static List<Kup> kups=new ArrayList<Kup>();    
    
    static List<Kup> endinade=new ArrayList<Kup>();    
    
    static List<Kup> reachs=new ArrayList<Kup>();


    static boolean finn=false;

    static int threshold=0;
    
    static List<Integer> reached=new ArrayList<Integer>();    
    static List<Integer> finished=new ArrayList<Integer>();

    static List<Integer> solusyon=new ArrayList<Integer>();
    static int node=0;

    static int bach=0;
    public static void main(String[] args) {
        int[] ahmet=Rotate.enkripshın(mix, cuba, next_cubait);
        kups.add(new Kup(ahmet,null, 0, 0, 0, 10));
        //System.out.println(Heuristic.heuristic(kups.get(0).getState(), goal, next_cubait));
        System.out.println("hehe");
        long start=System.currentTimeMillis();
        reached.add(threshold);
        reachs.add(kups.get(0));
        while(!finn){
            
            Kup top=kups.get(0);
            int cum=top.getGoMove()+1;
            int p=(int)(cum/10)*10;
            finn=CheckPlease.check(top.getState(), goal);
            for(;p<70&&!finn;p+=10){
                int s=cum-p;
                cum=p+11;
                if((int)top.getCumMove()/10==(int)p/10||((int)top.getCumMove()/10==1&&(int)p/10==2)||((int)top.getCumMove()/10==3&&(int)p/10==4)||((int)top.getCumMove()/10==5&&(int)p/10==6))
                    continue;
                for(;s<4;s+=1){
                    int m=p+s;       
                    int[] s_t=new int[20];
                    Rotate.eshithle(s_t, Rotate.enkripshın(m, top.getState(), next_cubait));
                    finn=CheckPlease.check(s_t, goal);
                    
                    int h_t=Heuristic.heuristic(s_t,bach ,goal, next_cubait);
                    h_t+=top.getStep()+1+bach;
                    Kup t=new Kup(s_t, top.getState(), h_t, top.getStep()+1, m, 10);
                    node++;
                    top.setGoMove(m);
                    //reachs.add(t);
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
            }/*
            if(!finn){
                idashReverse.do_a_favor(ahmet, reachs);
                finn=idashReverse.finn;
            }*/
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
                        kups.add(new Kup(Rotate.enkripshın(mix, cuba, next_cubait),null, 0, 0, 0, 10));
                        solusyon.clear();
                        //reachs.clear();
                        //reachs.add(kups.get(0));
                    }
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("finn and solved "+node);
        System.out.println(end-start);
        for(int i=0;i<solusyon.size();i++){
            System.out.print(Rotate.enkripshın(solusyon.get(i))+" ");
        }
    }
}
