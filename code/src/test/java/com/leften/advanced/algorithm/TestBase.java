package com.leften.advanced.algorithm;

import com.leften.advanced.algorithm.ch1.prog11.Prog1;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author lei.liu
 * @since 2019-04-04 18:30
 */
public abstract class TestBase {

    protected void getPath(Class<? extends Prog1> chClass, String relative) {
        String testClassPath = TestBase.class.getResource("/").getPath();
        String[] nameSplittedByDot = StringUtils.split(chClass.getPackage().getName(), ".");
        ArrayUtils.reverse(nameSplittedByDot);
        testClassPath += "../../../docs/" + nameSplittedByDot[1] + "/" + nameSplittedByDot[0];
        System.out.println(testClassPath);
        String path = new File(testClassPath).getPath();
        System.out.println(path);
    }
}
