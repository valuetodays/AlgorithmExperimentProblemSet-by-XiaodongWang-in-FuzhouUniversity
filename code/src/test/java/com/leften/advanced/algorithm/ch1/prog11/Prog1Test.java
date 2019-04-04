package com.leften.advanced.algorithm.ch1.prog11;

import com.leften.advanced.algorithm.TestBase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lei.liu
 * @since 2019-04-04 18:23
 */
public class Prog1Test extends TestBase {
    private Prog1 prog1;

    @Before
    public void before() {
        prog1 = new Prog1();
    }

    @Test
    public void cal() {
        String testClassPath = prog1.getClass().getResource("/").getPath();
        System.out.println(testClassPath);
        int[] cal = prog1.cal(1);
        super.getPath(prog1.getClass(), "/");
    }

}