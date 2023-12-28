package librar;

public class Rotate {
    public static void L(int[] pen,int[][] next){
        int[] order={2,1,3};
        rotate(pen, next, order, 0, 1, 0);
    }
    public static void R(int[] pen,int[][] next){
        int[] order={2,1,3};
        rotate(pen, next, order, 12, 13, 0);
    }
    public static void U(int[] pen,int[][] next){
        int[] order={1,3,2};
        rotate(pen, next, order, 0, 1, 1);
    }
    public static void D(int[] pen,int[][] next){
        int[] order={1,3,2};
        rotate(pen, next, order, 6, 5, 1);
    }
    public static void F(int[] pen,int[][] next){
        int[] order={3,2,1};
        rotate(pen, next, order, 0, 8, 2);
    }
    public static void B(int[] pen,int[][] next){
        int[] order={3,2,1};
        rotate(pen, next, order, 2, 9, 2);
    }
    public static void rotate(int[] pen,int[][] next,int[] order,int a, int b,int method){
        int c=pen[a];
        int ne=next[a][method];
        int n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;
        
        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;

        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;
       
        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;

        c=pen[b];
        ne=next[b][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;

        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;
        
        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;

        ne=next[ne][method];
        n=pen[ne];
        pen[ne]=swap(c, order);
        c=n;
    }
    public static int[] enkripshın(String[] moves,int[] pencil,int[][] next){
        int[] pen =new int[20];
        eshithle(pen, pencil);
        for(int i=0;i<moves.length;i++){
            int rep=1;
            if(moves[i].length()==2){
                if((moves[i].charAt(1))=='2'){
                    rep=2;
                }
                else
                    rep=3;
            }
            for(int ii=0;ii<rep;ii++){
                if((moves[i].charAt(0))=='R')
                    R(pen,next);
                if((moves[i].charAt(0))=='L')
                    L(pen,next);
                if((moves[i].charAt(0))=='U')
                    U(pen,next);
                if((moves[i].charAt(0))=='D')
                    D(pen,next);
                if((moves[i].charAt(0))=='F')
                    F(pen,next);
                if((moves[i].charAt(0))=='B')
                    B(pen,next);
            }
        }
        return pen;
    }
    public static int[] enkripshın(int move,int[] pencil,int[][] next){
        int[] pen =new int[20];
        eshithle(pen, pencil);
        int primer=move/10;
        int sekonder=move-primer*10;
        for(int ii=0;ii<sekonder;ii++){
            if(primer==1)
                R(pen,next);
            if(primer==2)
                L(pen,next);
            if(primer==3)
                U(pen,next);
            if(primer==4)
                D(pen,next);
            if(primer==5)
                F(pen,next);
            if(primer==6)
                B(pen,next);
        }
        return pen;
    }
    public static String enkripshın(int move){
        String ali="";
        int p=move/10;
        int s=move-p*10;
        if(p==1){
            ali+="R";
        }
        if(p==2){
            ali+="L";
        }
        if(p==3){
            ali+="U";
        }
        if(p==4){
            ali+="D";
        }
        if(p==5){
            ali+="F";
        }
        if(p==6){
            ali+="B";
        }
        if(s==2){
            ali+="2";
        }
        if(s==3)
            ali+="'";
        return ali;
    }
    public static int swap(int a,int[] order){
        int r=0;
        int[] aa =new int[3];
        aa[0] =a/100;
        aa[1]=(a-(aa[0]*100))/10;
        aa[2]=a-(aa[0]*100+aa[1]*10);
        r=aa[order[0]-1]*100+aa[order[1]-1]*10+aa[order[2]-1];
        return r;
    }
    public static void eshithle(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            a[i]=b[i];
        }
    }
}
