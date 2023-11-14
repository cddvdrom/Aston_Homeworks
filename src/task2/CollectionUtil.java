package task2;

import java.util.List;

public class CollectionUtil {
    public String getFirst (List <String> list){
      //  return (list.size()==0) ? "0" : list.get(0) ;
        return list.stream().findFirst().orElse("0");
    }
    public String getLast (List <String> list){
     //   return (list.size()==0) ? "0" : list.get(list.size()-1) ;
        long counter = list.size();
        return list.stream().skip(counter - 1).findFirst().orElse("0");
    }
}
