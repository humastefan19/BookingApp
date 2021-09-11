package accomodationapp.demo.aspect;

import accomodationapp.demo.entity.LogTable;
import accomodationapp.demo.repository.LogTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    private final LogTableRepository logTableRepository;

    public LoggingAspect(LogTableRepository logTableRepository) {
        this.logTableRepository = logTableRepository;
    }

    @AfterReturning("execution(* accomodationapp.demo.service.*.*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " will be executed. Timestamp: " + LocalDateTime.now());

        LogTable logTable = new LogTable(joinPoint.getSignature().toString(), joinPoint.getTarget().getClass().getCanonicalName(), LocalDateTime.now());
        logTableRepository.save(logTable);
    }
}
