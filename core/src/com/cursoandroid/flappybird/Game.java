package com.cursoandroid.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cursoandroid.flappybird.GameConfigs.GameCameraConfig;
import com.cursoandroid.flappybird.GameConfigs.GameSounds;
import com.cursoandroid.flappybird.GameConfigs.GameStatusControl;
import com.cursoandroid.flappybird.GameConfigs.GameText;
import com.cursoandroid.flappybird.ScreenObjConfigs.PipesConfig;
import com.cursoandroid.flappybird.ScreenObjConfigs.PositionBirdConfig;
import com.cursoandroid.flappybird.ScreenObjConfigs.Shapes;
import com.cursoandroid.flappybird.ScreenObjConfigs.Textures;

import java.util.Random;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Random random;
	Textures textures = new Textures();
	PositionBirdConfig positionConfigs = new PositionBirdConfig();
	PipesConfig pipesConfig = new PipesConfig();
	GameStatusControl gameStatusControl = new GameStatusControl();
	Shapes shapes = new Shapes();
	GameText gameText = new GameText();
	GameSounds gameSounds = new GameSounds();
	GameCameraConfig gameCameraConfig = new GameCameraConfig();


	@Override
	public void create () {
		initializeTextures();
		initializeObjects();
	}

	@Override
	public void render () {
		//clean frames
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		checkGameState();
		pointsValidation();
		drawObjects();
		collisionDetection();
	}

	private void initializeTextures(){
		//birds
		Texture[] birds = new Texture[3];
		birds[0] = new Texture("passaro1.png");
		birds[1] = new Texture("passaro2.png");
		birds[2] = new Texture("passaro3.png");
		textures.setBirds(birds);

		//background
		textures.setBackground(new Texture("fundo.png"));

		textures.setBottomPipe(new Texture("cano_baixo_maior.png"));

		textures.setTopPipe(new Texture("cano_topo_maior.png"));

		textures.setGameOver(new Texture("game_over.png"));
	}

	private void initializeObjects(){
		batch = new SpriteBatch();

		random = new Random();

		gameText.setTextPoints(new BitmapFont());
		gameText.getTextPoints().setColor(Color.WHITE);
		gameText.getTextPoints().getData().setScale(10);

		gameText.setTextRestart(new BitmapFont());
		gameText.getTextRestart().setColor(Color.TEAL);
		gameText.getTextRestart().getData().setScale(2);

		gameText.setTextBestPontuation(new BitmapFont());
		gameText.getTextBestPontuation().setColor(Color.RED);
		gameText.getTextBestPontuation().getData().setScale(2);

		pipesConfig.setWidthDispositive(gameCameraConfig.getVIRTUAL_WIDTH());

		pipesConfig.setHeightDispositive(gameCameraConfig.getVIRTUAL_HEIGHT());

		positionConfigs.setBirdFirstPosY(pipesConfig.getHeightDispositive() / 2);

		pipesConfig.setPipeMovementX(pipesConfig.getWidthDispositive());

		pipesConfig.setSpacePipes(220);

		//geometric collisions
		shapes.setShapeRenderer(new ShapeRenderer());
		shapes.setBirdCircle(new Circle());
		shapes.setBottomPipeRectangle(new Rectangle());
		shapes.setTopPipeRectangle(new Rectangle());

		//sounds
		gameSounds.setFlyingSound(Gdx.audio.newSound(Gdx.files.internal("som_asa.wav")));

		gameSounds.setCollisionSound(Gdx.audio.newSound(Gdx.files.internal("som_batida.wav")));

		gameSounds.setPointSound(Gdx.audio.newSound(Gdx.files.internal("som_pontos.wav")));

		//config prefs
		gameStatusControl.setPrefs(Gdx.app.getPreferences("flappyBird"));
		gameStatusControl.setMaxPontuation(gameStatusControl.getPrefs().getInteger("maxPoints", 0));

		//camera config
		gameCameraConfig.setCamera(new OrthographicCamera());
		gameCameraConfig.getCamera().position.set(gameCameraConfig.getVIRTUAL_WIDTH()/2, gameCameraConfig.getVIRTUAL_HEIGHT()/2, 0);
		gameCameraConfig.setViewport(new StretchViewport(gameCameraConfig.getVIRTUAL_WIDTH(), gameCameraConfig.getVIRTUAL_HEIGHT(), gameCameraConfig.getCamera()));

	}

	@Override
	public void resize(int width, int height) {
		gameCameraConfig.getViewport().update(width, height);
	}

	private void collisionDetection(){
		int birdRadiusX = textures.getBirds(0).getWidth() / 2;

		int birdRadiusY = textures.getBirds(0).getHeight() / 2;

		float birdCircleXPos = 50 + positionConfigs.getPositionHorizontalBird() + birdRadiusX;
		float topPipeRectangleY = pipesConfig.getHeightDispositive() / 2 + pipesConfig.getSpacePipes() / 2 + pipesConfig.getPipeMovementY();
		float bottomPipeRectangleY = pipesConfig.getHeightDispositive() / 2 - textures.getBottomPipe().getHeight() - pipesConfig.getSpacePipes() / 2 + pipesConfig.getPipeMovementY();

		shapes.getBirdCircle().set(birdCircleXPos, positionConfigs.getBirdFirstPosY() + birdRadiusY, birdRadiusX);

		shapes.getTopPipeRectangle().set(pipesConfig.getPipeMovementX(), topPipeRectangleY,
				textures.getTopPipe().getWidth(), textures.getTopPipe().getHeight());

		shapes.getBottomPipeRectangle().set(pipesConfig.getPipeMovementX(), bottomPipeRectangleY,
				textures.getBottomPipe().getWidth(), textures.getBottomPipe().getHeight());

		if(Intersector.overlaps(shapes.getBirdCircle(), shapes.getTopPipeRectangle()) ||
				Intersector.overlaps(shapes.getBirdCircle(), shapes.getBottomPipeRectangle()) || shapes.getBirdCircle().y <= 5.0){
			Gdx.app.log("Log", "Colidiu");
			if(gameStatusControl.getStatusGame() == 1){
				gameSounds.getCollisionSound().play();
				gameStatusControl.setStatusGame(2);
			}
		}
	}

	private void drawObjects(){
		float bottomPipeY = pipesConfig.getHeightDispositive() / 2 - textures.getBottomPipe().getHeight() - pipesConfig.getSpacePipes() / 2 + pipesConfig.getPipeMovementY();
		float topPipeY = pipesConfig.getHeightDispositive() / 2 + pipesConfig.getSpacePipes() / 2 + pipesConfig.getPipeMovementY();

		float gameOverImageX = pipesConfig.getWidthDispositive() / 2 - textures.getGameOver().getWidth() / 2;

		batch.setProjectionMatrix(gameCameraConfig.getCamera().combined);

		//draw objects in the screen
		batch.begin();

		batch.draw(textures.getBackground(), 0, 0, pipesConfig.getWidthDispositive(), pipesConfig.getHeightDispositive());

		batch.draw(textures.getBirds((int) positionConfigs.getVariation()), 50 + positionConfigs.getPositionHorizontalBird(), positionConfigs.getBirdFirstPosY());

		batch.draw(textures.getBottomPipe(), pipesConfig.getPipeMovementX(), bottomPipeY);

		batch.draw(textures.getTopPipe(), pipesConfig.getPipeMovementX(), topPipeY);

		gameText.getTextPoints().draw(batch, String.valueOf(gameStatusControl.getPoints()), pipesConfig.getWidthDispositive() / 2 - gameStatusControl.getPoints(), pipesConfig.getHeightDispositive() - 110);

		if(gameStatusControl.getStatusGame() == 2){
			//draw the text to restart the game
			batch.draw(textures.getGameOver(), gameOverImageX, pipesConfig.getHeightDispositive() / 2);
			gameText.getTextRestart().draw(batch,
					"Touch the screen to restart",
					pipesConfig.getWidthDispositive() / 2 - 140 ,
					pipesConfig.getHeightDispositive() / 2 - textures.getGameOver().getHeight() / 2);

			gameText.getTextBestPontuation().draw(batch,
					"Your record: " + gameStatusControl.getMaxPontuation() + " points",pipesConfig.getWidthDispositive() / 2 - 140,
					pipesConfig.getHeightDispositive() / 2 - textures.getGameOver().getHeight());
		}

		batch.end();
	}

	private void checkGameState(){
		/*
		* 0 - bird paused
		* 1 - start the game
		* 2 - collision
		* */

		boolean screenTouch = Gdx.input.justTouched();

		if(gameStatusControl.getStatusGame() == 0){
			/*event click*/
			if(screenTouch){
				positionConfigs.setBirdGravity(-15);
				gameStatusControl.setStatusGame(1);
				gameSounds.getFlyingSound().play();
			}
		}else if(gameStatusControl.getStatusGame() == 1 ){
			/*event click*/
			if(screenTouch){
				positionConfigs.setBirdGravity(-15);
				gameStatusControl.setStatusGame(1);
				gameSounds.getFlyingSound().play();
			}
			/*moves the pipe*/
			pipesConfig.setPipeMovementX(pipesConfig.getPipeMovementX() - Gdx.graphics.getDeltaTime() * 200);
			if(pipesConfig.getPipeMovementX() < -textures.getBottomPipe().getWidth()){
				pipesConfig.setPipeMovementX(pipesConfig.getWidthDispositive());
				pipesConfig.setPipeMovementY(random.nextInt(400) - 300);
				positionConfigs.setPipePassed(false);
			}

			/*gravity to the bird*/
			if(positionConfigs.getBirdFirstPosY() > 0 || screenTouch)
				positionConfigs.setBirdFirstPosY(positionConfigs.getBirdFirstPosY() - positionConfigs.getBirdGravity());

			positionConfigs.setBirdGravity(positionConfigs.getBirdGravity() + 1);
		}else if( gameStatusControl.getStatusGame() == 2){
			if(gameStatusControl.getPoints() > gameStatusControl.getMaxPontuation()){
				gameStatusControl.setMaxPontuation(gameStatusControl.getPoints());
				gameStatusControl.getPrefs().putInteger("maxPoints", gameStatusControl.getMaxPontuation());
			}

			positionConfigs.setPositionHorizontalBird(positionConfigs.getPositionHorizontalBird() - Gdx.graphics.getDeltaTime() * 500);

			/*event click*/
			if(screenTouch){
				gameStatusControl.setStatusGame(0);
				gameStatusControl.setPoints(0);
				positionConfigs.setBirdGravity(0);
				positionConfigs.setPositionHorizontalBird(0);
				positionConfigs.setBirdFirstPosY(pipesConfig.getHeightDispositive() / 2);
				pipesConfig.setPipeMovementX(pipesConfig.getWidthDispositive());
			}
		}

	}

	private void pointsValidation(){
		if(pipesConfig.getPipeMovementX() < 50 - textures.getBirds(0).getWidth() && !positionConfigs.isPipePassed()){
			gameStatusControl.setPoints(gameStatusControl.getPoints() + 1);
			positionConfigs.setPipePassed(true);
			gameSounds.getPointSound().play();
		}
		positionConfigs.setVariation(positionConfigs.getVariation() + Gdx.graphics.getDeltaTime() * 10);

		/*checks variation to control the wings of the bird*/
		if(positionConfigs.getVariation() > 3){
			positionConfigs.setVariation(0);
		}
	}

	@Override
	public void dispose () {
		Gdx.app.log("dispose", "Descarte de conteúdos");
	}
}
