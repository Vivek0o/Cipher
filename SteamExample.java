import java.util.*;
import java.util.stream.*;
public class Streamex {
    public static void main(String[] args) {
        List<Integer> number=Arrays.asList(1,2,3,4);
        List<Integer> square=number.stream().map(x->x*x).collect(Collectors.toList()); 
        List<String> name=Arrays.asList("Sumit","Puneet","Vivek","Aarsh");
        List<String> result=name.stream().filter(s->s.endsWith("t")).collect(Collectors.toList());
        List<String> sort=name.stream().sorted().collect(Collectors.toList());
        Integer even=number.stream().filter(x->x%2==0).reduce(0,(ans,i)->ans+i);
        System.out.print(even);
    }
}
