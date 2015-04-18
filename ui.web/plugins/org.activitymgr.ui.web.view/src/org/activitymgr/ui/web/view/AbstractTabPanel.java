package org.activitymgr.ui.web.view;

import java.util.ArrayList;
import java.util.List;

import org.activitymgr.ui.web.logic.IButtonLogic;
import org.activitymgr.ui.web.logic.IDownloadButtonLogic;
import org.activitymgr.ui.web.logic.ITabLogic;
import org.activitymgr.ui.web.view.impl.internal.util.ButtonView;
import org.activitymgr.ui.web.view.impl.internal.util.DownloadButtonView;

import com.vaadin.event.Action;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public abstract class AbstractTabPanel<LOGIC extends ITabLogic<?>> extends VerticalLayout implements ITabLogic.View<LOGIC>{

	private IResourceCache resourceCache;
	private LOGIC logic;
	private VerticalLayout actionsContainer;
	private List<ShortcutListener> actions = new ArrayList<ShortcutListener>();
	private Component bodyComponent;

	public AbstractTabPanel(IResourceCache resourceCache) {
		this.resourceCache = resourceCache;
		setSpacing(true);
		setMargin(true);
		
		// Header
		Component header = createHeaderComponent();
		if (header != null) {
			addComponent(header);
		}
		
		// Horizontal layout
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		addComponent(hl);
		
		// Header
		Component leftComponent = createLeftComponent();
		if (leftComponent != null) {
			hl.addComponent(leftComponent);
		}

		// Body
		bodyComponent = createBodyComponent();
		hl.addComponent(bodyComponent);

		// Add actions panel
		actionsContainer = new VerticalLayout();
		hl.addComponent(actionsContainer);

	}
	
	protected Component createHeaderComponent() {
		return null;
	}

	protected Component createLeftComponent() {
		return null;
	}

	protected abstract Component createBodyComponent();

	@Override
	public void registerLogic(LOGIC logic) {
		this.logic = logic;
		
		if (bodyComponent instanceof Action.Container) {
			Action.Container actionContainer = (Action.Container) bodyComponent;
			actionContainer.addActionHandler(new Action.Handler() {
				@Override
				public void handleAction(Action action, Object sender, Object target) {
					((ShortcutListener) action).handleAction(sender, target);
				}
				@Override
				public Action[] getActions(Object target, Object sender) {
					return (Action[]) actions.toArray(new Action[actions.size()]);
				}
			});
		}
	}

	protected IResourceCache getResourceCache() {
		return resourceCache;
	}
	
	protected LOGIC getLogic() {
		return logic;
	}
	
	@Override
	public void addButton(String label, char key,
			boolean ctrl, boolean shift, boolean alt, final IButtonLogic.View buttonView) {
		// Add button to action container
		ButtonView button = (ButtonView) buttonView;
		actionsContainer.addComponent(button);
		
		// Register a menu and a shortcut
		int[] rawModifiers = new int[3];
		int i = 0;
		if (ctrl)
			rawModifiers[i++] = ShortcutListener.ModifierKey.CTRL;
		if (shift)
			rawModifiers[i++] = ShortcutListener.ModifierKey.SHIFT;
		if (alt)
			rawModifiers[i++] = ShortcutListener.ModifierKey.ALT;
		int[] modifiers = new int[i];
		System.arraycopy(rawModifiers, 0, modifiers, 0, i);
		ShortcutListener newAction = new ShortcutListener(button.getDescription(),
				button.getIcon(), key, modifiers) {
			@Override
			public void handleAction(Object sender, Object target) {
				((Button)buttonView).click();
			}
		};
		actions.add(newAction);
		addShortcutListener(newAction);
	}
	
	@Override
	public void addDownloadButton(IDownloadButtonLogic.View buttonView) {
		// Add button to action container
		DownloadButtonView button = (DownloadButtonView) buttonView;
		actionsContainer.addComponent(button);
	}
}