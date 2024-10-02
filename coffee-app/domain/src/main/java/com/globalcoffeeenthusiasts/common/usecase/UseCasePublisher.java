package com.globalcoffeeenthusiasts.common.usecase;

import com.globalcoffeeenthusiasts.common.model.UseCase;

public interface UseCasePublisher {
    <R, T extends UseCase> R publish(Class<R> returnClass, T useCase);

    <R, T extends UseCase> void publish(T useCase);

    <R> R publish(Class<R> returnClass);
}
