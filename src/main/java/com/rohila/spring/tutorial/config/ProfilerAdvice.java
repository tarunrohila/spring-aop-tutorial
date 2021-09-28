package com.rohila.spring.tutorial.config;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * this class is used to put advice around methods.
 * 
 * @author Tarun Rohila
 */
@Aspect
@Component
public class ProfilerAdvice implements Ordered {

	/**
	 * Member variable declaration for order.
	 */
	private final int order = 1;

	/**
	 * Member variable declaration for Logger.
	 */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Member variable declaration for COLON.
	 */
	private static final String COLON = ":";

	/**
	 * Member variable declaration for CONT_MARK.
	 */
	private static final String CONT_MARK = "...";

	/**
	 * Class member variable declaration for METHOD_DENOTOR.
	 */
	private static final String METHOD_DENOTOR = "()";

	/**
	 * Member variable declaration for service marker.
	 */
	private static final Marker SERVICE_MARKER = MarkerManager.getMarker("service");

	/**
	 * this method put advice on methods.
	 * 
	 * @param pjp pjp
	 * @return Object
	 * @throws Throwable exception
	 */
	@Around("ServicePointCut.allResources()")
	public final Object aroundAdvice(final ProceedingJoinPoint pjp) throws Throwable {
		Object output = null;
		long start = System.nanoTime();

		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(SERVICE_MARKER,
						new StringBuilder().append("Entered Inside ").append(pjp.getSignature().getDeclaringType())
								.append(COLON).append(pjp.getSignature().getName()).append(METHOD_DENOTOR)
								.append(CONT_MARK).toString());
			}
			output = pjp.proceed();
		} finally {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(SERVICE_MARKER,
						new StringBuilder().append("Exiting From ").append(pjp.getSignature().getDeclaringType())
								.append(COLON).append(pjp.getSignature().getName()).append(METHOD_DENOTOR)
								.append(CONT_MARK).toString());

				long elapsedTime = System.nanoTime() - start;

				elapsedTime = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
				LOGGER.debug(SERVICE_MARKER, new StringBuilder().append(pjp.getSignature().getDeclaringTypeName())
						.append(COLON).append(pjp.getSignature().getName()).append(METHOD_DENOTOR)
						.append(" method execution took ").append(elapsedTime).append(" milliseconds").toString());
			}
		}
		return output;
	}

	@AfterThrowing(value = "ServicePointCut.allResources()", throwing="ex")
	public final Object afterThrowingAdvice(JoinPoint joinPoint, Exception ex) throws Throwable {
		Object output = null;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(SERVICE_MARKER,
						new StringBuilder().append("Exception occurred inside").append(joinPoint.getSignature().getDeclaringType())
								.append(COLON).append(joinPoint.getSignature().getName()).append(METHOD_DENOTOR)
								.append(CONT_MARK).toString());
			}
			output = joinPoint.toString();
		return output;
	}

	/**
	 * order.
	 *
	 * @return int
	 */
	public int getOrder() {
		return order;
	}
}
