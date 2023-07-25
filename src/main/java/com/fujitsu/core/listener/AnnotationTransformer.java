package com.fujitsu.core.listener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import com.fujitsu.core.util.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * Implements {@link IAnnotationTransformer} to leverage certain functionality like
 * updating the annotations of test
 * methods at runtime.
 * Please make sure to add the listener details in the testng.xml file
 *
 * @author Sumit Goyal
 * @version 1.0
 * @since 1.0
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer{

	/**
	 * Helps in setting the dataprovider,
	 * dataprovider class and retry analyser annotation to all the test methods
	 * at run time. 
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

	

}
