package ca.amazon.ta.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * IAnnotationTransformer modifies the default TestNG tests behavior at run time. 
 * And here this class implemented it to set retryAnalyzer for all test.
 * Note: AnnotationTransformer has not been used as class level retryAnalyzer is implemented in this project. 
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
