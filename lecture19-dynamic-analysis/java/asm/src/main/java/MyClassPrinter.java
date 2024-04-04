import org.objectweb.asm.*;
import static org.objectweb.asm.Opcodes.ASM6;

public class MyClassPrinter extends ClassVisitor {

    public MyClassPrinter() {
        super(ASM6);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    public void visitSource(String source, String debug) {

    }

    public void visitOuterClass(String owner, String name, String desc) {

    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    public void visitAttribute(Attribute attr) {

    }

    public void visitInnerClass(String name, String outerName,String innerName, int access) {

    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println("It's a field\t" + access + ": " + name + " " + desc);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("It's a method\t" + access + ": " + name + " " + desc);
        return null;
    }

    public void visitEnd() {
        System.out.println("}");
    }
}


