package validator;

import data.ArraySize;
public class SizeOfArrayValidator {
    public boolean isValid(int size) {
        return size == ArraySize.RIGHT_SIZE.getSize();
    }
}
