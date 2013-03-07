package org.phl0w.updater.version;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

public class Jar {

    public static Double getVersion(final String path) {
        double d = 0.0;
        final ClassNode main = loadMainClass(path.substring(path.lastIndexOf("\\") + 1, path.indexOf(".jar") + 4));
        try {
            for (final MethodNode mn : main.methods) {
                if (mn.name.equals("checkVersion")) {
                    for (AbstractInsnNode a : mn.instructions.toArray()) {
                        if (a instanceof LdcInsnNode) {
                            final LdcInsnNode lin = (LdcInsnNode) a;
                            if (lin.cst instanceof String) {
                                final String s = (String) lin.cst;
                                if (Pattern.matches("\\d+(\\.\\d{1,2})?", s))
                                    d = Double.parseDouble(s);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    private static ClassNode loadMainClass(String jarName) {
        try {
            final JarFile file = new JarFile(jarName);
            final Enumeration<JarEntry> entries = file.entries();
            ClassNode node = null;
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().contains("nl/wbot/Main.class")) {
                    System.out.println("-> Class found..." + entry.getName());
                    InputStream is = file.getInputStream(entry);
                    ClassReader reader = new ClassReader(is);
                    node = new ClassNode();
                    reader.accept(node, 0);
                    break;
                }
            }
            return node;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
