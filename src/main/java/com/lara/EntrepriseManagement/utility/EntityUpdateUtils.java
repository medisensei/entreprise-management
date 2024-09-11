package com.lara.EntrepriseManagement.utility;

import java.util.function.Consumer;

public class EntityUpdateUtils {

    public static void updateFieldIfNotNullOrEmpty(String field, Consumer<String> setter) {
        if (field != null && !field.isEmpty()) {
            setter.accept(field);
        }
    }

}
