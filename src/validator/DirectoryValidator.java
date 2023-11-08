package validator;

import java.io.File;

public class DirectoryValidator implements MyValidator{
    @Override
    public boolean isValid(String line) {
        File dir=new File(line);

        return dir.isDirectory()&&dir.exists();
    }
}
