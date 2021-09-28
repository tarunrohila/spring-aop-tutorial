package com.rohila.spring.tutorial.config;

import org.aspectj.lang.annotation.Pointcut;

/**
 * This class create service point cut expression to apply on profiler advice.
 * 
 * @author Tarun Rohila
 *
 */
public class ServicePointCut {

	/**
	 * Pointcut for all web tier resources implement.
	 */
	@Pointcut("execution(public * com.rohila.spring.tutorial..*.*(..))"
			+ " && excludeSetterGetter() && excludeAllConfigClasses()")
	public void allResources() {
	}

	/**
	 * pointcut to exclude all getter setter classes.
	 */
	@Pointcut("!(execution (public * com.rohila.spring.tutorial.dto..*.set*(..)))"
			+ " && !(execution (public * com.rohila.spring.tutorial.repository.domain..*.get*()))")
	private void excludeSetterGetter() {
	}

	/**
	 * pointcut to exclude all config classes.
	 */
	@Pointcut("!within (com.rohila.spring.tutorial.config..*)")
	private void excludeAllConfigClasses() {
	}
}
