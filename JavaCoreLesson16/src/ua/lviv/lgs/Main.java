package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, ReflectiveOperationException, InvocationTargetException {
		Class person = Person.class;
		System.out.println("Name of class = " + person.getName());
		System.out.println("Simple name  =  " + person.getSimpleName());
		System.out.println("Package of current class =  " + person.getPackageName());
		System.out.println();
		System.out
				.println("Class modifier = " + person.getModifiers() + " " + Modifier.toString(person.getModifiers()));
		System.out.println("is static = " + Modifier.isStatic(person.getModifiers()));
		System.out.println("is public = " + Modifier.isPublic(person.getModifiers()));
		System.out.println("is abstract = " + Modifier.isAbstract(person.getModifiers()));
		System.out.println();
		System.out.println("Super class = " + person.getSuperclass());
		System.out.println("Interfaces =  " + Arrays.toString(person.getInterfaces()));
		System.out.println();
		Constructor<Person>[] personConstructor = person.getConstructors();
		for (int i = 0; i < personConstructor.length; i++) {
			Constructor<Person> constructor = personConstructor[i];
			System.out.println("Constructor = " + constructor);

		}
		System.out.println("Constructors size = " + personConstructor.length);
		Constructor<Person> constructor = personConstructor[2];
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println("Parameter types of constructor = " + class1);

		}
		System.out.println();
		System.out.println("get Consctuctor by parameters and set the value of name and age");
		Constructor<Person> singleConstructor = person.getConstructor(String.class, int.class);
		System.out.println("single consctror = " + singleConstructor);
		Person newInstancePerson = singleConstructor.newInstance("John", 44);
		System.out.println("reflection Person = " + newInstancePerson);
		System.out.println();
		System.out.println("get Fields without private");
		Field[] fields = person.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();
		System.out.println("get Declared Fields");

		fields = person.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();
		Field ageField = person.getField("age");
		ageField.set(newInstancePerson, 100);
		System.out.println("Person with new age" + newInstancePerson);

		Field privateField = fields[3];
		privateField.setAccessible(true);
		privateField.set(newInstancePerson, "Dancing without music");
		System.out.println("Set private Value hobby = " + newInstancePerson);
		System.out.println();
		System.out.println("Get Methods");
		Method[] methods = person.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}
		System.out.println();
		System.out.println("invoke method for change name");

		methods[4].invoke(newInstancePerson, "Rorry");

		System.out.println(newInstancePerson);

		System.out.println();
		System.out.println("Calling own methods:");
		System.out.println("doSmth");
		Method method = person.getMethod("doSmth", String.class);
		method.invoke(newInstancePerson, "Freya");
		
		System.out.println("agePlusTen");
		Method method1 = person.getMethod("agePlusTen", int.class);
		method1.invoke(newInstancePerson, 40 );
		
		

		
	}
}
