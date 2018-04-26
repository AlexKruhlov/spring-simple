package ua.rafael.bean.resourcesaccess;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceAccess {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		File file = File.createTempFile("test", "txt");
		file.deleteOnExit();
		System.out.println(file.getPath());
		Resource resource = context.getResource("file://" + file.getPath());
		displayInfo(resource);
	}

	private static void displayInfo(Resource resource) throws IOException {
		System.out.println(resource.getClass());
		System.out.println(resource.getURL().getContent());
		System.out.println("");
	}
}
