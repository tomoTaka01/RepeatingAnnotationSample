package com.my.test;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

/**
 *
 * @author tomo
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("*")
public class ProcessorTest8 extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        class Scanner extends ElementScanner8<Void, Void>{

            @Override
            public Void visitVariable(VariableElement e, Void p) {
                System.out.println(String.format("variable:%s", e));
                return super.visitVariable(e, p); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Void visitType(TypeElement e, Void p) {
                System.out.println(String.format("type:%s", e));
                return super.visitType(e, p); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Void visitExecutable(ExecutableElement e, Void p) {
                System.out.println(String.format("Executable:%s", e));
                return super.visitExecutable(e, p); //To change body of generated methods, choose Tools | Templates.
            }

        }
        Scanner scanner = new Scanner();
        for (Element root : roundEnv.getRootElements()) {
            scanner.scan(root);
        }
        return true;
    }

}
