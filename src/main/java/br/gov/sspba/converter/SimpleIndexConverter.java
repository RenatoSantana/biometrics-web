package br.gov.sspba.converter;


import java.util.List;

import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.FacesConverter;
import javax.persistence.EmbeddedId;  
import javax.persistence.Id;  

import java.lang.reflect.Field;
import java.util.ArrayList;


//import static net.sf.trugger.element.Elements.element;  
//import static net.sf.trugger.reflection.ReflectionPredicates.annotatedWith;  

@FacesConverter("br.gov.sspba.converter.SimpleIndexConverter")
public class SimpleIndexConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		if (value != null) {
			return component.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object obj) {
		
		
		
		if (obj != null && !"".equals(obj)) {
			String id;
			try {
				id = this.getId(getClazz(ctx, component), obj);
				if (id == null) {
					id = "";
				}
				id = id.trim();
				component.getAttributes().put(id,
						getClazz(ctx, component).cast(obj));
				return id;
			} catch (SecurityException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); // seu log aqui
			} catch (NoSuchFieldException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalAccessException e) {
				e.printStackTrace(); // seu log aqui
			}
		}
		return null;
	}

	/**
	 * Obtém, via expression language, a classe do objeto.
	 *
	 * @param FacesContext facesContext
	 * 
	 * @param UICompoment compoment
	 *     
	 * @return  Class<?>
	 */
	private Class<?> getClazz(FacesContext facesContext, UIComponent component) {
		return component.getValueExpression("value").getType(
				facesContext.getELContext());
	}


	/**
	 * Retorna a representação em String do retorno do método anotado com @Id ou @EmbeddedId do objeto.
	 *
	 * @param Class<?> clazz
	 *            
	 * @return  String
	 */
	public String getId(Class<?> clazz, Object obj) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {

		List<Class<?>> hierarquiaDeClasses = this.getHierarquiaDeClasses(clazz);
		
		for (Class<?> classeDaHierarquia : hierarquiaDeClasses) {
			for (Field field : classeDaHierarquia.getDeclaredFields()) {
				if ((field.getAnnotation(Id.class)) != null
						|| field.getAnnotation(EmbeddedId.class) != null) {
					Field privateField = classeDaHierarquia
							.getDeclaredField(field.getName());
					privateField.setAccessible(true);
					if (privateField.get(clazz.cast(obj)) != null) {

						return (String) field.getType()
								.cast(privateField.get(clazz.cast(obj)))
								.toString();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista com a hierarquia de classes, sem considerar a classe Object.class
	 *
	 * @param Class<?> clazz
	 *            
	 * @return  List<Class<?>> clazz
	 */
	public List<Class<?>> getHierarquiaDeClasses(Class<?> clazz) {

		List<Class<?>> hierarquiaDeClasses = new ArrayList<Class<?>>();
		Class<?> classeNaHierarquia = clazz;
		while(classeNaHierarquia != Object.class) {
			hierarquiaDeClasses.add(classeNaHierarquia);
			classeNaHierarquia = classeNaHierarquia.getSuperclass();
			
		}
		return hierarquiaDeClasses;
	} 

}