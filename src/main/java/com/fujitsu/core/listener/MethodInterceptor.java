package com.fujitsu.core.listener;

import java.util.ArrayList;
import java.util.List;

import com.fujitsu.core.constants.Constants;
import com.fujitsu.core.constants.FrameworkConstants;
import com.fujitsu.core.util.Utility;
import com.fujitsu.core.util.XlsReader;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 * Implements {@link IMethodInterceptor} to
 * leverage the abstract methods Mostly used to read the data from excel and
 * decides on which tests need to run.
 *
 * Please make sure to add the listener details in the testng.xml file
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */
public class MethodInterceptor implements IMethodInterceptor {
    /**
     * Intercepts the existing test methods and changes the annotation value at the run time Values are fetched from the
     * excel sheet. User has to choose yes/No in the RunManager sheet. Suppose if there are 3 tests named a,b,c needs to
     * be run, it reads the excel and understand user wants to run only a and c, then it will return the same after
     * performing the comparisons.
     */

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        XlsReader rd = new XlsReader (String.format(FrameworkConstants.EXCEL, Constants.PORTFOLIO_SUITE) + ".xlsx");
        List<IMethodInstance> result = new ArrayList<>();
        for (IMethodInstance method : methods) {
            if (Utility.isTestCaseRunnable(method.getMethod().getMethodName(), rd)) {
                result.add(method);
            }
        }

        return result;
    }

}
