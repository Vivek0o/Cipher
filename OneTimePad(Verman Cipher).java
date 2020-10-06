import java.util.Scanner;
import java.util.Arrays;;
public class OTP{
    static String encrypt(String msg, String key){
        char[] msg_=msg.toCharArray();
        char[] key_=key.toCharArray();
        String res="";
        for(int i=0;i<msg.length();i++){
            int num1= ((int)(msg_[i]))-65;
            int num2= ((int)(key_[i]))-65;
            res+=(char)((num1^num2)+65);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg,key;
        System.out.println("Enter Message: ");
        msg=sc.nextLine();
        System.out.println("Enter Key: ");
        key=sc.nextLine();
        String enc=encrypt(msg,key);
        System.out.println(enc);
    }
}
