package org.activitymgr.ui.web.logic;

import org.activitymgr.core.dto.Collaborator;

public interface ILogicContext {

	IEventBus getEventBus();
	
	Collaborator getConnectedCollaborator();

	void setConnectedCollaborator(
			Collaborator connectedCollaborator);

	<EXTENSION_TYPE, CONSTRUCTOR_ARG_TYPE> EXTENSION_TYPE getSingletonExtension(
			String extensionPointId, Class<EXTENSION_TYPE> defaultType,
			Class<CONSTRUCTOR_ARG_TYPE> constructorArgType,
			CONSTRUCTOR_ARG_TYPE constructorArg);

	//	public <EXTENSION_TYPE, CONSTRUCTOR_ARG_TYPE> List<EXTENSION_TYPE> getExtensions(
	//			String extensionPointId, Class<CONSTRUCTOR_ARG_TYPE> constructorArgType,
	//			CONSTRUCTOR_ARG_TYPE constructorArg) {
	//		List<EXTENSION_TYPE> result = new ArrayList<EXTENSION_TYPE>();
	//		IConfigurationElement[] cfgs = Activator.getDefault().getExtensionRegistryService().getConfigurationElementsFor(extensionPointId);
	//		for (IConfigurationElement cfg : cfgs) {
	//			try {
	//				Class<EXTENSION_TYPE> type = Activator.getDefault().<EXTENSION_TYPE>loadClass(cfg.getContributor().getName(), cfg.getAttribute("class"));
	//				result.add(newExtensionInstance(type, constructorArgType, constructorArg));
	//				
	//			} catch (ClassNotFoundException e) {
	//				throw new IllegalStateException(e);
	//			}
	//		}
	//		return result;
	//	}
	//
	<EXTENSION_TYPE, CONSTRUCTOR_ARG_TYPE> EXTENSION_TYPE newExtensionInstance(
			Class<EXTENSION_TYPE> type,
			Class<CONSTRUCTOR_ARG_TYPE> constructorArgType,
			CONSTRUCTOR_ARG_TYPE constructorArg);

}