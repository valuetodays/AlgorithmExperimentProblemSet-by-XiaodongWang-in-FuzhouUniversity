package com.leften.advanced.algorithm.ch1.prog11;

import com.leften.advanced.algorithm.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void testCal() {
        int[] answer = prog1.cal(0);
        Assert.assertEquals(0, answer[0]);
        Assert.assertEquals(0, answer[1]);
        answer = prog1.cal(1);
        Assert.assertEquals(0, answer[0]);
        Assert.assertEquals(1, answer[1]);
        answer = prog1.cal(2);
        Assert.assertEquals(0, answer[0]);
        Assert.assertEquals(1, answer[1]);
        Assert.assertEquals(1, answer[2]);
    }

    @Test
    public void testAutoCalBase() {
        List<TestAndAnswer> testAndAnswerList = super.getTestAndAnswer();
        for (TestAndAnswer testAndAnswer : testAndAnswerList) {
            List<String> testList = testAndAnswer.getTestList();
            List<String> answerList = testAndAnswer.getAnswerList();
            // 一行测试对应10行答案
            Assert.assertEquals(1, testList.size());
            Assert.assertEquals(10, answerList.size());
            Assert.assertEquals(testList.size() * 10, answerList.size());

            int[] answer = prog1.cal(Integer.parseInt(testList.get(0)));
            Assert.assertEquals(answer.length, answerList.size());
            for (int i = 0; i < answer.length; i++) {
                Assert.assertEquals(answer[i], Integer.parseInt(answerList.get(i)));
            }
        }
    }

    @Test
    public void testAutoCalEx() {
        super.autoTest(1, 10, (testList, answerList) -> {
            int[] answer = prog1.cal(Integer.parseInt(testList.get(0)));
            Assert.assertEquals(answer.length, answerList.size());
            for (int i = 0; i < answer.length; i++) {
                Assert.assertEquals(answer[i], Integer.parseInt(answerList.get(i)));
            }
        });
    }

}