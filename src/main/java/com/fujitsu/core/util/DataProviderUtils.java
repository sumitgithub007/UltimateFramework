package com.fujitsu.core.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import com.fujitsu.core.constants.Constants;
import com.fujitsu.core.constants.FrameworkConstants;

/**
 * Holds the data provider for all the test cases in the framework.
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 */
public final class DataProviderUtils {

    /**
     * Acts as a data provider for all the test cases.
     * Parallel=true indicates that each of the iteration will be run in
     * parallel.
     *
     * @param m {@link Method} holds the information about the testcases at runtime
     *
     * @return Object[] containing the List. Each index of the list contains HashMap and each of them contains the test
     *     data needed to run the iterations.
     *
     * @author Sumit Goyal
     */
    @DataProvider (parallel = true)
    public static Object[] getData (Method m) {
        List<Map<String, String>> list = new ArrayList<> ();

        XlsReader xls1 = new XlsReader (
            String.format(FrameworkConstants.EXCEL, Constants.PORTFOLIO_SUITE) + ".xlsx");
        String testname = m.getName ();
        System.out.println (m.getName ());
        list = Utility.getMapData (testname, xls1);
        System.out.println (list);
        List<Map<String, String>> smalllist = new ArrayList<> (list);
        Predicate<Map<String, String>> isExecuteColumnNo = map -> map.get (Constants.RUNMODE_COL)
            .equalsIgnoreCase ("N");
        smalllist.removeIf (isExecuteColumnNo);
        return smalllist.toArray ();
    }

    private DataProviderUtils () {
    }
}
