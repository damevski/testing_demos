import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

public class ModifyMethodSignatureCV extends ClassVisitor {

    public ModifyMethodSignatureCV(ClassVisitor cv) {
        super(ASM8, cv);
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (access == ACC_PUBLIC) {
            return cv.visitMethod(ACC_PRIVATE, name, desc, signature, exceptions);
        }
        else {
            return cv.visitMethod(access, name, desc, signature, exceptions);
        }
    }

}
