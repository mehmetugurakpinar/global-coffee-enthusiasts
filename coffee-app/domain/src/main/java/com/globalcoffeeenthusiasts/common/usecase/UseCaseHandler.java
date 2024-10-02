package com.globalcoffeeenthusiasts.common.usecase;

import com.globalcoffeeenthusiasts.common.model.UseCase;

public interface UseCaseHandler<R, T extends UseCase> {
    R handle(T var1);
}

