package com.innotechnum.prpaha.data.generator;

import com.google.inject.AbstractModule;
import com.innotechnum.prpaha.data.generator.repository.OfficeRepository;
import com.innotechnum.prpaha.data.generator.repository.ToStringWithTabOfficeRepository;
import com.innotechnum.prpaha.data.generator.services.CacheOfficesFetchService;
import com.innotechnum.prpaha.data.generator.services.OfficeSerializer;
import com.innotechnum.prpaha.data.generator.services.OfficesFetchService;
import com.innotechnum.prpaha.data.generator.services.OperationSerializer;
import com.innotechnum.prpaha.data.generator.services.ToStringWithTabOfficeSerializer;
import com.innotechnum.prpaha.data.generator.services.ToStringWithTabOperationSerializer;

/**
 * Guice конфигурация приложения.
 */
public class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OperationSerializer.class).to(ToStringWithTabOperationSerializer.class);
        bind(OfficeSerializer.class).to(ToStringWithTabOfficeSerializer.class);
        bind(OfficesFetchService.class).to(CacheOfficesFetchService.class);
        bind(OfficeRepository.class).to(ToStringWithTabOfficeRepository.class);
    }
}
