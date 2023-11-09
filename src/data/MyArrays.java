package data;


public enum MyArrays {
    RIGHT_ARRAY(new String[]{"1", "2", "3"}),
    WRONG_ARRAY(new String[]{"22", "j", "22"});

    private String[] array;

    MyArrays(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }
}
