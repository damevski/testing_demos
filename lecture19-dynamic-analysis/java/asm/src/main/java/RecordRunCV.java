import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class RecordRunCV extends ClassVisitor {

    private String className = "Default";

    public RecordRunCV(ClassVisitor cv) {
        super(ASM7, cv);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // GRAB CLASS NAME HERE
        this.className = name;
    }

    // @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv != null) {
            // PASS CLASSNAME
            mv = new RecordMethodVisitor(mv, this.className);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        System.out.println("I'M AT THE END");
    }

    class RecordMethodVisitor extends MethodVisitor {

        private String className = "new-default";

        public RecordMethodVisitor(MethodVisitor mv, String className) {
            super(ASM7, mv);
            // GET CLASSNAME
            this.className = className + ", ";
        }

        @Override
        public void visitLineNumber(int line, Label start) {
            //mv.visitLdcInsn(this.className);
//            mv.visitVarInsn(ASTORE, 4);
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitVarInsn(ALOAD, 4);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

            // WORKS
            // System.out.print(this.className);
            // mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
            // "Ljava/io/PrintStream;");
            // mv.visitLdcInsn("Test, ");
            // mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print",
            // "(Ljava/lang/String;)V", false);

            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitIntInsn(BIPUSH, line);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        }

    }
}
