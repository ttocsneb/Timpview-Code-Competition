package com.ttocsneb.inventory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.ttocsneb.inventory.save.SaveData;
import com.ttocsneb.inventory.window.Stock;

public class Inventory extends ApplicationAdapter {

	public static SaveData save;

	/**
	 * The stage contains/renders all objects held within it.
	 */
	Stage stage;


	/*
	 * (non-Javadoc)
	 * 
	 * Called when the {@link Application} is first created.
	 *
	 * @see com.badlogic.gdx.ApplicationAdapter#create()
	 */
	@Override public void create() {
		save = new SaveData();
		save.load();

		// Create a stage with the dimensions of the window.
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		// Load the assets for the stage.
		VisUI.load();

		stage.addActor(new Stock(stage).window);
		
		/*
		 * SaveData.Item i = save.new Item(); i.id = 42; i.name = "TestItem";
		 * i.price = 1.02f; i.stock = 64;
		 * 
		 * save.stock.put(i.id, i); save.save();
		 */
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * Called when the {@link Application} should render itself.
	 * 
	 * @see com.badlogic.gdx.ApplicationAdapter#render()
	 */
	@Override public void render() {
		// Clear the screen with a white color
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// update, and draw the stage.
		stage.act();
		stage.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * Called when the {@link Application} is resized. This can happen at any
	 * point during a non-paused state but will never happen before a call to
	 * {@link #create()}.
	 * 
	 * @param width the new width in pixels
	 * 
	 * @param height the new height in pixels
	 * 
	 * @see com.badlogic.gdx.ApplicationAdapter#resize(int, int)
	 */
	@Override public void resize(int width, int height) {
		// Resize the stage when the window resizes.
		stage.getViewport().update(width, width);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * Called when the {@link Application} is destroyed. Preceded by a call to
	 * {@link #pause()}.
	 * 
	 * @see com.badlogic.gdx.ApplicationAdapter#dispose()
	 */
	@Override public void dispose() {
		// unload the assets/stage when the program closes.
		VisUI.dispose();
		stage.dispose();
	}
}
