package com.ClassLoader;

import java.io.File;

/**
 * Created by tancw on 2016/10/13.
 */
public class FileSystemClassLoader extends ClassLoader {

	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getCLassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getCLassData(String className) {
		String path = classNameToPath(className);
		return new byte[0];
	}

	private String classNameToPath(String className) {
		return rootDir + File.separator + className.replace(".", File.separator) + ".class";
	}
}
