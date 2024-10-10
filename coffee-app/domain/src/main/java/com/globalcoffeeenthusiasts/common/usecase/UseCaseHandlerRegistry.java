package com.globalcoffeeenthusiasts.common.usecase;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseCaseHandlerRegistry {
    private static final Logger log = LoggerFactory.getLogger(UseCaseHandlerRegistry.class);
    private final Map<Class<? extends UseCase>, UseCaseHandler<?, ? extends UseCase>> registryForUseCaseHandlers = new HashMap<>();
    private final Map<Class<? extends UseCase>, VoidUseCaseHandler<? extends UseCase>> registryForVoidUseCaseHandlers = new HashMap<>();
    private final Map<Class<?>, NoUseCaseHandler<?>> registryForNoUseCaseHandlers = new HashMap<>();
    public static final UseCaseHandlerRegistry INSTANCE = new UseCaseHandlerRegistry();

    private UseCaseHandlerRegistry() {
    }

    public <R, T extends UseCase> void register(Class<T> key, UseCaseHandler<R, T> useCaseHandler) {
        log.info("Use case {} is registered by handler {}", key.getSimpleName(), useCaseHandler.getClass().getSimpleName());
        this.registryForUseCaseHandlers.put(key, useCaseHandler);
    }

    public <T extends UseCase> void register(Class<T> key, VoidUseCaseHandler<T> useCaseHandler) {
        log.info("Use case {} is registered by void handler {}", key.getSimpleName(), useCaseHandler.getClass().getSimpleName());
        this.registryForVoidUseCaseHandlers.put(key, useCaseHandler);
    }

    public <R> void register(Class<R> key, NoUseCaseHandler<R> useCaseHandler) {
        log.info("Use case {} is registered by no param handler {}", key.getSimpleName(), useCaseHandler.getClass().getSimpleName());
        this.registryForNoUseCaseHandlers.put(key, useCaseHandler);
    }

    public UseCaseHandler<?, ? extends UseCase> detectUseCaseHandlerFrom(Class<? extends UseCase> useCaseClass) {
        return (UseCaseHandler)this.registryForUseCaseHandlers.get(useCaseClass);
    }

    public VoidUseCaseHandler<? extends UseCase> detectVoidUseCaseHandlerFrom(Class<? extends UseCase> useCaseClass) {
        return (VoidUseCaseHandler)this.registryForVoidUseCaseHandlers.get(useCaseClass);
    }

    public NoUseCaseHandler<?> detectNoUseCaseHandlerFrom(Class<?> returnClass) {
        return (NoUseCaseHandler)this.registryForNoUseCaseHandlers.get(returnClass);
    }

    public Map<Class<? extends UseCase>, UseCaseHandler<?, ? extends UseCase>> getRegistryForUseCaseHandlers() {
        return this.registryForUseCaseHandlers;
    }

    public Map<Class<? extends UseCase>, VoidUseCaseHandler<? extends UseCase>> getRegistryForVoidUseCaseHandlers() {
        return this.registryForVoidUseCaseHandlers;
    }

    public Map<Class<?>, NoUseCaseHandler<?>> getRegistryForNoUseCaseHandlers() {
        return this.registryForNoUseCaseHandlers;
    }
}
