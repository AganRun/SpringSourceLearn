package com.agan.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * @author agan
 */
public class DayCondition implements Condition {

    /**
     * 周末双休，这个类不工作
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        DayOfWeek index = LocalDateTime.now().getDayOfWeek();
        if (index.equals(DayOfWeek.SUNDAY) || index.equals(DayOfWeek.SATURDAY)) {
            return false;
        }
        return true;
    }
}
