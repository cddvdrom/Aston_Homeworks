package data;

public enum ArraySize {
    RIGHT_SIZE(4),
    WRONG_SIZE(5);

private int size;
ArraySize(int size){
    this.size=size;
}
public int getSize(){
    return size;
}
}