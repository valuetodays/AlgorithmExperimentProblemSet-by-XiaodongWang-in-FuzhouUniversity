package com.leften.advanced.algorithm;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.liu
 * @since 2019-04-04 18:30
 */
public abstract class TestBase {
    public void autoTest(int numberPerTest, int numberPerAnswer, AutoTestCase autoTestCase) {
        List<TestAndAnswer> testAndAnswerList = this.getTestAndAnswer();
        for (TestAndAnswer testAndAnswer : testAndAnswerList) {
            List<String> testList = testAndAnswer.getTestList();
            List<String> answerList = testAndAnswer.getAnswerList();
            // 一行测试对应10行答案
            Assert.assertEquals(numberPerTest, testList.size());
            Assert.assertEquals(numberPerAnswer, answerList.size());

            autoTestCase.doAutoTest(testList, answerList);


        }
    }

    protected static class TestAndAnswer {
        private final List<String> testList;
        private final List<String> answerList;

        public TestAndAnswer(List<String> testList, List<String> answerList) {
            this.testList = testList;
            this.answerList = answerList;
        }

        public List<String> getTestList() {
            return testList;
        }

        public List<String> getAnswerList() {
            return answerList;
        }
    }

    protected interface AutoTestCase {
        void doAutoTest(List<String> testList, List<String> answerList);
    }

    protected List<TestAndAnswer> getTestAndAnswer() {
        List<TestAndAnswer> testAndAnswerList = new ArrayList<>();
        try {
            File path = getBasePath();
            String testPath = path.getAbsolutePath() + "/test";
            String answerPath = path.getAbsolutePath() + "/answer";
            File[] files = new File(testPath).listFiles();
            for (File testFile : files) {
                FileInputStream fisTest = new FileInputStream(testFile);
                List<String> testList = IOUtils.readLines(fisTest, "UTF-8");
                /*for (String s : testList) {
                    System.out.println(s);
                }*/
                IOUtils.closeQuietly(fisTest);

                String answerFile = answerPath + "/" + testFile.getName().replace(".in", ".out");
                FileInputStream fisAnswer = new FileInputStream(new File(answerFile));
                List<String> answerList = IOUtils.readLines(fisAnswer, "UTF-8");
                /*for (String s : answerList) {
                    System.out.println(s);
                }*/
                IOUtils.closeQuietly(fisAnswer);
                testAndAnswerList.add(new TestAndAnswer(testList, answerList));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return testAndAnswerList;
    }

    private File getBasePath() {
        String testClassPath = TestBase.class.getResource("/").getPath();
        String[] nameSplittedByDot = StringUtils.split(getClass().getPackage().getName(), ".");
        ArrayUtils.reverse(nameSplittedByDot);
        testClassPath += "../../../docs/" + nameSplittedByDot[1] + "/" + nameSplittedByDot[0];
        return new File(testClassPath);
    }
}
