package org.activitymgr.ui.web.logic.impl;

import org.activitymgr.ui.web.logic.IEventBus;
import org.activitymgr.ui.web.logic.IGenericCallback;
import org.activitymgr.ui.web.logic.ILogic;

public abstract class AbstractSafeGenericCallback<RESULT> extends AbstractSafeCallback implements IGenericCallback<RESULT> {

	public AbstractSafeGenericCallback(ILogic<?> source, IEventBus eventBus) {
		super(source, eventBus);
	}

	@Override
	public void callback(RESULT result) {
		try {
			unsafeCallback(result);
		}
		catch (Throwable t) {
			fireCallbackExceptionEvent(t);
		}
	}

	protected abstract void unsafeCallback(RESULT result) throws Exception;

}