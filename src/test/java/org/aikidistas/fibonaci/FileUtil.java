package org.aikidistas.fibonaci;

import java.util.Scanner;

public class FileUtil {

    private FileUtil() {

    }

    public static String read(String resourceFileName) {
        return new Scanner(CalculatorImplTest.class.getResourceAsStream(resourceFileName), "UTF-8")
                .useDelimiter("\\A")
                .next();
    }
}
