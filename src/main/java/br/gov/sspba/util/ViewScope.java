package br.gov.sspba.util;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ViewScope implements Scope , Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Logger logger = LoggerFactory.getLogger(ViewScope.class);

	@Override
	@SuppressWarnings("rawtypes")
	public Object get(final String name, final ObjectFactory objectFactory) {
		final Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			Object bean = viewMap.get(name);			

			// restore a transient autowired beans after re-serialization bean
			WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();
			AutowireCapableBeanFactory autowireFactory = webAppContext.getAutowireCapableBeanFactory();
			
			if (webAppContext.containsBean(name)) {
				
				// Reconfigure resored bean instance.
				bean = autowireFactory.configureBean(bean, name);
			}
			// end restore
			
			return bean;
		} else {
			final Object object = objectFactory.getObject();
			viewMap.put(name, object);

			return object;
		}
	}

	@Override
	public String getConversationId() {
		return null;
	}

	@Override
	public void registerDestructionCallback(final String name, final Runnable callback) {
		// Not supported
	}

	@Override
	public Object remove(final String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
	}

	@Override
	public Object resolveContextualObject(final String key) {
		return null;
	}
}