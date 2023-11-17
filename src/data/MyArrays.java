package data;
public enum MyArrays {
    RIGHT_ARRAY(new String [][]
            {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
            }
    ),
    WRONG_DATA_ARRAY(new String [][]
            {
                    {"22", "j", "22", "ll"},
                    {"22", "j", "22", "ll"},
                    {"22", "j", "22", "ll"},
                    {"22", "j", "22", "ll"},
            }
    ),
    WRONG_SIZE_ARRAY(new String [][]
            {
                    {"22", "j", "22", "ll"},
                    {"22", "j", "22", "ll"},
                    {"22", "j", "22"}

            }
    );
    private final String [][] array;
    MyArrays(String [][] array) {
        this.array = array;
    }
    public String [][] getArray() {
        return array;
    }
}
