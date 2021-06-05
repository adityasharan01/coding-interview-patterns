import java.util.*;
import java.io.*;
import java.lang.*;
  
class GFG { 
    static final int d=256;
    static final int q=101;   
    static void RBSearch(String pat,String txt,int M, int N){
    
    //Compute (d^(M-1))%q
    int h=1;
    for(int i=1;i<=M-1;i++)
        h=(h*d)%q;
    
    //Compute p and to
    int p=0,t=0;
    for(int i=0;i<M;i++){
        p=(p*d+pat.charAt(i))%q;
        t=(t*d+txt.charAt(i))%q;
    }
    
    for(int i=0;i<=(N-M);i++){
       //Check for hit
       if(p==t){
           boolean flag=true;
           for(int j=0;j<M;j++)
                if(txt.charAt(i+j)!=pat.charAt(j)){flag=false;break;}
            if(flag==true)System.out.print(i+" ");
       }
       //Compute ti+1 using ti
       if(i<N-M){
           t=((d*(t-txt.charAt(i)*h))+txt.charAt(i+M))%q;
        if(t<0)t=t+q;
       }
    }
    
}
  
    public static void main(String args[]) 
    {   String txt = "GEEKS FOR GEEKS";String pat="GEEK";
        System.out.print("All index numbers where pattern found: ");
        RBSearch(pat,txt,4,15);  
    } 
} 
