package librar;

import java.util.ArrayList;
import java.util.List;

public class Heuristic {
    public static int heuristic(int[] current, int[] goal, int[][] next){
        int h=0;
        int hh=0;
        int[][] s={{2,1,3},{1,3,2},{3,2,1}};
        for(int i=0;i<current.length;i++){
            int[] d=new int[3];
            Boolean f=false;
            d[0]=current[i]/100;
            d[1]=(current[i]-d[0]*100)/10;
            d[2]=current[i]-(d[0]*100+d[1]*10);
            Boolean edge=d[0]==8||d[1]==8||d[2]==8;
            for(int m=0;m<next[i].length;m++){
                if(d[1]==8){
                    if(m==2){
                        hh+=2;
                        break;
                    }
                }
                if(d[2]==8){
                    if(m==0){
                        m=1;
                    }
                }
                if(d[0]==8){
                    if(m==1){
                        m=2;
                    }
                }
                //System.out.println("orçunzade "+current[i]+" "+goal[i]);
                if(current[i]==goal[i]){
                    //System.out.println("orçunzade "+i);
                    f=true;
                    break;
                }
                int n=next[i][m];
                int c=Rotate.swap(current[i], s[m]);
                if(c==goal[n]){
                    if(edge)
                        hh+=1;
                    else
                        h+=1;
                    f=true;
                    break;
                }
                n=next[n][m];
                c=Rotate.swap(c, s[m]);
                if(c==goal[n]){
                    if(edge)
                        hh+=1;
                    else
                        h+=1;
                    f=true;
                    break;
                }
                n=next[n][m];
                c=Rotate.swap(c, s[m]);
                if(c==goal[n]){
                    if(edge)
                        hh+=1;
                    else
                        h+=1;
                    f=true;
                    break;
                }
                if(m==2){
                    if(edge)
                        hh+=1;
                    else
                        h+=1;
                }
            }
            if(!f){
                if(d[2]==8){
                    int deg=Rotate.swap(current[i], s[0]);
                    if((deg==goal[8])||deg==goal[9]||deg==goal[10]||deg==goal[11])
                        hh+=1;
                }
                if(d[1]==8){
                    int deg=Rotate.swap(current[i], s[2]);
                    if((deg==goal[1])||deg==goal[5]||deg==goal[13]||deg==goal[17])
                        hh+=1;
                }
                if(d[0]==8){
                    int deg=Rotate.swap(current[i], s[1]);
                    if((deg==goal[3])||deg==goal[7]||deg==goal[15]||deg==goal[19])
                        hh+=1;
                }
            }
        }
        return Math.max(h, hh);
    }
    public static int heuristic(int[] kup,int bach,int[] goal,int[][] next_cubait) {
        List<Integer> kups=new ArrayList<Integer>();
        kups.add(heuristic(kup, goal,next_cubait));
        int[] current=new int[20];
        for(int b=0;b<bach;b++){
            int[] anlik=new int[20];
            Rotate.eshithle(anlik, current);;
            int her=100;
            for(int pp=10;pp<70;pp+=10){
                for(int ss=1;ss<4;ss+=1){
                    Rotate.eshithle(anlik, Rotate.enkripshın(pp+ss, current, next_cubait));
                    if(b==bach-1){
                        int heur=heuristic(anlik, goal, next_cubait);
                        if(heur<her){
                            kups.add(0, heur);
                        }
                    }
                }
            }
        }
        return kups.get(0);
    }
}
