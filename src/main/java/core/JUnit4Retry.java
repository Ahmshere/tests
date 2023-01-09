package core;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class JUnit4Retry  implements TestRule {
    private int retryCount;

    public JUnit4Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement(){
            @Override
            public void evaluate() throws Throwable {
                Throwable err = null;
                for(int i = 0 ; i<retryCount; i++){
                    try {
                        base.evaluate(); return;
                    } catch (Throwable e) {

                        err = e;
                        System.err.println(description.getDisplayName()+" bil zapushen "+ (i+1)+" raz" );
                    }
                }
                System.err.println(description.getDisplayName()+ " Test failed after "+ retryCount);
                throw err;
            }


        };
    }
}
