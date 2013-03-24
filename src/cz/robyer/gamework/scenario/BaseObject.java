package cz.robyer.gamework.scenario;

import android.content.Context;
import cz.robyer.gamework.game.GameEventHandler;
import cz.robyer.gamework.util.Log;

public abstract class BaseObject {
	protected Scenario scenario;
	protected Context context;
	
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
		this.context = scenario.getContext();
	}
	
	public boolean isAttached() {
		return (scenario != null);
	}
	
	public Context getContext() {
		if (context == null) {
			Log.e("BaseObject", "BaseObject '" + this + "' is not attached to any Scenario");
			throw new RuntimeException();
		}
		
		return context;
	}
	
	public Scenario getScenario() {
		if (scenario == null) {
			Log.e("BaseObject", "BaseObject '" + this + "' is not attached to any Scenario");
			throw new RuntimeException();
		}
			
		return scenario;
	}
	
	public GameEventHandler getHandler() {
		GameEventHandler handler = getScenario().getHandler();
		if (handler == null) {
			Log.e("BaseObject", "Scenario have attached no GameEventHandler");
			throw new RuntimeException();
		}
		
		return handler;
	}
	
}
