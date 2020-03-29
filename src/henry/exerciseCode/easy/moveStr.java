package easy;

public class moveStr {

    public static void moveChar(char[] ch,int len)
    {
        int point=len-1;
        int let=len-1;

        while(point!=0&&let!=0)
        {
            while(ch[point]!='*'&&point!=0)  //first * from the end
            {
                point--;
            }
            if(point==0)             //all ch are *
                return;
            let=point;
            while(ch[let]=='*'&&let!=0)   //the first letter before *
            {
                let--;
            }
            while(ch[let]!='*'&&ch[point]=='*')
            {
                char tem=ch[let];
                ch[let]=ch[point];
                ch[point]=tem;
                if(point!=0)
                    point--;
                if(let!=0)
                    let--;
            }
        }
    }


    public static void main(String[] args)
    {
        String str="*c*m*b*n*t*";
        char[] ch=str.toCharArray();
        moveChar(ch,str.length());
        System.out.println(ch);
    }
}
