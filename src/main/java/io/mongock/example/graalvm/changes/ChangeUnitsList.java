package io.mongock.example.graalvm.changes;

import java.util.Arrays;
import java.util.List;

public final class ChangeUnitsList {

    public static final List<Class<?>> changeUnits = Arrays.asList(
            ACreateCollection.class,
            BInsertDocument.class,
            CInsertAnotherDocument.class
    );

    private ChangeUnitsList() {
    }


}
