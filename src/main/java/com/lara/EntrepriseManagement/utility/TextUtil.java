package com.lara.EntrepriseManagement.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class TextUtil {

    private final MessageSource messageSource;

    public String getMessage(String msg, Object... os) {
        return messageSource.getMessage(msg, os, LocaleContextHolder.getLocale());
    }
}
