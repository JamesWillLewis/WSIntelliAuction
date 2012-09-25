package com.uct.cs.wsintelliauction.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Superclass for classes which can be serialized and stored on the local file
 * system.
 * 
 * @author James
 * 
 */
public abstract class FileStorable<E> implements Serializable {

	/**
	 * Directory to which objects are stored
	 */
	private static final String STORE_DIR = "res/serialized/";

	private static final long serialVersionUID = -5999912006287018944L;

	public void store() {
		File objF = new File(STORE_DIR + getClass().getSimpleName() + ".obj");
		try {
			ObjectOutputStream stream = new ObjectOutputStream(
					new FileOutputStream(objF));
			stream.writeObject(this);
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e) {
			ErrorLogger.log(e.getMessage());
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	public abstract E newInstance();

	public E load() {
		File objF = new File(STORE_DIR + getClass().getSimpleName() + ".obj");
		E obj = null;
		if (objF.exists()) {

			try {
				ObjectInputStream stream = new ObjectInputStream(
						new FileInputStream(objF));
				obj = (E) stream.readObject();
				stream.close();
			} catch (FileNotFoundException e) {
				ErrorLogger.log(e.getMessage());
				return newInstance();
			} catch (IOException e) {
				ErrorLogger.log(e.getMessage());
				return newInstance();
			} catch (ClassNotFoundException e) {
				ErrorLogger.log(e.getMessage());
				return newInstance();
			}
		} else {
			return newInstance();
		}
		return obj;
	}

}
