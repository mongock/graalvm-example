package io.mongock.example.graalvm;

import io.mongock.example.graalvm.changes.ChangeUnitsList;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

public class ChangeUnitsRegistrationFeature implements Feature {

    public void beforeAnalysis(BeforeAnalysisAccess access) {
        ChangeUnitsList.changeUnits.forEach(ChangeUnitsRegistrationFeature::registerClass);
    }

    private static void registerClass(Class<?> clazz) {
        RuntimeReflection.register(clazz);
        RuntimeReflection.register(clazz.getDeclaredConstructors());
        RuntimeReflection.register(clazz.getDeclaredMethods());
    }


}
