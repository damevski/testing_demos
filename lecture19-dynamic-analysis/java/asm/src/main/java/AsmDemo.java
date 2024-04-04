import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AsmDemo {

    private static String classPath = "/Users/kdamevski/classes/CMSC425/spring2023/demos/lecture17-asm/examples/";
    private static String templateClassFileName = classPath + "Template.class";
    private static String test2ClassFileName = classPath + "Test2.class";

    private static void printClass(String filename) throws IOException {
        ClassReader cr = new ClassReader(new FileInputStream(filename));
        MyClassPrinter cp = new MyClassPrinter();
        cr.accept(cp, 0);
    }

    /*v.1 - simple visitor*/
//    public static void main(String[] args) throws IOException {
//        printClass(templateClassFileName);
//    }


    /*v.2 - introducing writer*/
//    public static void main(String[] args) throws IOException {
//        ClassReader cr = new ClassReader(new FileInputStream(templateClassFileName));
//        ClassWriter cw = new ClassWriter(cr, 0);
//        cr.accept(cw, 0);
//        FileOutputStream fos = new FileOutputStream(classPath + "Double.class");
//        fos.write(cw.toByteArray());
//    }

    /*v.3 - basic transformation*/
    public static void main(String[] args) throws IOException {
        printClass(templateClassFileName);
        ClassReader cr = new ClassReader(new FileInputStream(templateClassFileName));
        ClassWriter cw = new ClassWriter(cr, 0);
        ModifyMethodSignatureCV instrumenter = new ModifyMethodSignatureCV(cw);
        cr.accept(instrumenter, 0);
        FileOutputStream fos = new FileOutputStream(classPath + "TemplateInstrumented.class");
        fos.write(cw.toByteArray());

        printClass(classPath + "TemplateInstrumented.class");
    }

    /*v.4 - complex transformation*/
//    public static void main(String[] args) throws IOException {
//        printClass(test2ClassFileName);
//        ClassReader cr = new ClassReader(new FileInputStream(test2ClassFileName));
//        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
//        RecordRunCV instrumenter = new RecordRunCV(cw);
//        cr.accept(instrumenter, 0);
//        FileOutputStream fos = new FileOutputStream(classPath + "Test2Instrumented.class");
//        fos.write(cw.toByteArray());
//    }

}
