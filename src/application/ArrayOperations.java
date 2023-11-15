package application;

import data.ArraySize;
import exception.MyArrayDataException;
import exception.MyArraySizeException;
import validator.ArrayCellValueValidator;
import validator.SizeOfArrayValidator;

public class ArrayOperations {
    public int sum(String[][] array) {
        SizeOfArrayValidator sizeValidator = new SizeOfArrayValidator();
        ArrayCellValueValidator valueValidator = new ArrayCellValueValidator();
        try
        {
            if (!sizeValidator.isValid(array.length))
            {
                throw new MyArraySizeException("В данном массиве "
                        + (array.length) + " строки " + "вместо " + ArraySize.RIGHT_SIZE.getSize());
            }
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        {
            try
            {
                if (!sizeValidator.isValid(array[i].length))
                {
                    throw new MyArraySizeException
                            ("В строке " + i + " неверное количество столбцов " + (array[i].length) + " , вместо " +
                                    ArraySize.RIGHT_SIZE.getSize());
                }
            } catch (MyArraySizeException e)
            {
                System.out.println(e.getMessage());
            }
            for (int j = 0; j < array[i].length; j++) {
                try
                {
                    if (!valueValidator.isValid(array[i][j]))
                    {
                        throw new MyArrayDataException("[" + (i) + "]" + "[" + (j) + "]");
                    }
                } catch (MyArrayDataException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }
}
