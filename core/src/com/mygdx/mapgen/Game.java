package com.mygdx.mapgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mapgen.common.Entity;
import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.World;
import com.mygdx.mapgen.common.services.IGamePluginService;
import com.mygdx.mapgen.mapgenerator.MapGenerationPlugin;

import java.util.ArrayList;
import java.util.List;

public class Game implements ApplicationListener {
	private static OrthographicCamera cam;
	private ShapeRenderer sr;
	private final GameData gameData = new GameData();
	private World world = new World();
	private List<IGamePluginService> entityPlugins = new ArrayList<>();


	@Override
	public void create () {
		gameData.setDisplayWidth(Gdx.graphics.getWidth());
		gameData.setDisplayHeight(Gdx.graphics.getHeight());

		cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
		cam.translate(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
		cam.update();

		sr = new ShapeRenderer();







		IGamePluginService mapGenerationPlugin = new MapGenerationPlugin();
		entityPlugins.add(mapGenerationPlugin);
		for (IGamePluginService iGamePlugin : entityPlugins) {
			iGamePlugin.start(gameData, world);
			//TEST COMMENT
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {

		// clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameData.setDelta(Gdx.graphics.getDeltaTime());

		update();

		draw();
	}

	private void update() {
		// Update

	}

	private void draw() {
		//draw
		drawGameMap();

	}

	private void drawGameMap() {
		for(Entity mapEntity : world.getGameMap().getMapComponents()){

			//DRAW THE MAP
			sr.setColor(1.0f, 0.0f, 0.0f, 1);

			sr.begin(ShapeRenderer.ShapeType.Line);

			float[] shapex = mapEntity.getShapeX();
			float[] shapey = mapEntity.getShapeY();

			for (int i = 0, j = shapex.length - 1;
				 i < shapex.length;
				 j = i++) {

				sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
			}

			sr.end();
		}

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {

	}
}
