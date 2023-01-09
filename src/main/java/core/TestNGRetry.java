package core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {

    private int counter = 0;
    private int maxCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            if(counter < maxCount){
                counter++;
                return true;
            }
        }

        return false;
    }
}
