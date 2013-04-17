package com.my.test;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("*")
public class InfoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            System.out.println(String.format("Annotation:%s" , annotation.toString()));
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
            for (Element ele : elements) {
                System.out.println(String.format("  Element:%s", ele));
                List<? extends AnnotationMirror> annotationMirrors = ele.getAnnotationMirrors();
                for (AnnotationMirror mirror : annotationMirrors) {
                    Map<? extends ExecutableElement, ? extends AnnotationValue> values = mirror.getElementValues();
                    for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : values.entrySet()) {
                        System.out.println(String.format("    key=%s, value=%s", entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return true;
    }
}
