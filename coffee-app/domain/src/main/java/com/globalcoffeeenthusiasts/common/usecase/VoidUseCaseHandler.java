package com.globalcoffeeenthusiasts.common.usecase;

import com.globalcoffeeenthusiasts.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {
    void handle(T var1);
}
