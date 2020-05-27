package cn.skcks.other;

/*
    数字反转
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(test(-2147483412));
        System.out.println(test(-2147483647));
        System.out.println(test(2147483647));
    }

    public static int test(int x){
        if(x > -10 && x < 10) return x;
        else if(x <= 0x80000000 || x>= 0x7fffffff) return 0;
        else if(x > 1000000003 && x%10 >= 3) return 0;
        else if(x < -1000000003 && x%10 <= -3) return 0;

        long res = 0;
        while (x != 0)
        {
            res = res * 10 + x % 10;
            if(res > 0x7fffffff || res < 0x80000000)
            {
                return 0;
            }
            x /= 10;
        }
        return (int)res;
    }
}
