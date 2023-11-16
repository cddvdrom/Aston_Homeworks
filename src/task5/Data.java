package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    private List<String> listData;
    public Data() {
        this.listData = new ArrayList<>();
    }
    public List<String> getListData() {
        return listData;
    }
public void setData( List <String> listData){
        this.listData = listData;
}
    public List<String> findDataCondition(SearchCondition condition, String item) {
        return listData.stream().filter(x -> condition.compare(x, item)).collect(Collectors.toList());
    }
}
