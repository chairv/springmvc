package example.asm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by tancw on 2015/12/8.
 */
public class GeneratorAsm {
	public static void main(String[] args) throws Exception {
		ClassWriter cw = new ClassWriter(0);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE, "com/comm/Compareble", null, "java/lang/Object",
				null);
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
		cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        byte[] data = cw.toByteArray();
        File file = new File("D:\\Workspaces\\springmvc\\target\\classes\\com\\comm\\Compareble.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.flush();
        fout.close();
        System.out.printf("game over");
    }
}
