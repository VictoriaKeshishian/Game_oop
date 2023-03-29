package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.oopGame.BaseHero;
import com.mygdx.game.oopGame.ClassPeasant;
import com.mygdx.game.oopGame.InfantryClass.Outlaw;
import com.mygdx.game.oopGame.InfantryClass.Spearman;
import com.mygdx.game.oopGame.MagClass.Magician;
import com.mygdx.game.oopGame.MagClass.Monk;
import com.mygdx.game.oopGame.ShooterClass.Crossbowman;
import com.mygdx.game.oopGame.ShooterClass.Snipper;
import java.util.ArrayList;
import java.util.Random;
import static com.mygdx.game.Programm.step;
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, magician, monk, outlaw, peasant, sniper, spearMan;
	public static final int GANG_SIZE = 10;
	public static ArrayList<BaseHero> whiteSide = new ArrayList<>();
	public static ArrayList<BaseHero> darkSide = new ArrayList<>();
	private static int step = 0;
	private static float dx, dy;
	//private Texture[] units;

	//private static Scanner sc;

	@Override
	public void create() {
		batch = new SpriteBatch();
		fon = new Texture("fons/" + String.valueOf(new Random().nextInt(4)) + ".png");
		Init();
		//sc = new Scanner(System.in);
		int my = 0;
		crossBowMan = new Texture("units/CrossBowMan.png");
		my = crossBowMan.getHeight();
		magician = new Texture("units/Magician.png");
		if (my < magician.getHeight()) my = magician.getHeight();
		monk = new Texture("units/Monk.png");
		if (my < monk.getHeight()) my = monk.getHeight();
		outlaw = new Texture("units/Outlaw.png");
		if (my < outlaw.getHeight()) my = outlaw.getHeight();
		peasant = new Texture("units/Peasant.png");
		if (my < peasant.getHeight()) my = peasant.getHeight();
		sniper = new Texture("units/Sniper.png");
		if (my < sniper.getHeight()) my = sniper.getHeight();
		spearMan = new Texture("units/SpearMan.png");
		if (my < spearMan.getHeight()) my = spearMan.getHeight();
		dx = dy = (float) Gdx.graphics.getHeight() / 10;

	}

	@Override
	public void render() {
//		batch.begin();
//		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (step++ == 0) {
			if (step == 0) Gdx.graphics.setTitle("Первый ход."); else Gdx.graphics.setTitle("Ход №"+step);
			batch.begin();
			batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			darkSide.forEach(n -> {
				switch (n.getName()) {
					case "Sniper":
						if (n.isAlive()) batch.draw(sniper, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Peasant":
						if (n.isAlive()) batch.draw(peasant, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Magician":
						if (n.isAlive()) batch.draw(magician, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Outlaw":
						if (n.isAlive()) batch.draw(outlaw, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
				}
			});
			whiteSide.forEach(n -> {
				switch (n.getName()) {
					case "Monk":
						if (n.isAlive()) batch.draw(monk, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Peasant":
						if (n.isAlive()) batch.draw(peasant, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Spearman":
						if (n.isAlive()) batch.draw(spearMan, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
					case "Crossbowman":
						if (n.isAlive()) batch.draw(crossBowMan, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy);break;
				}
			});
			batch.end();
			if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				//ConsoleView.view();
				step++;
				step();
			}
		}
	}
	public static void Init() {

		for (int i = GANG_SIZE; i > 0; i--) {
			switch(new Random().nextInt(4)){
				case 0:
					whiteSide.add(new ClassPeasant(BaseHero.generateName(), 1, i));break;
				case 1:
					whiteSide.add(new Spearman(BaseHero.generateName(), 1, i));break;
				case 2:
					whiteSide.add(new Monk(BaseHero.generateName(), 1, i));break;
				default:
					whiteSide.add(new Crossbowman(BaseHero.generateName(), 1, i));break;
			}
			switch(new Random().nextInt(4)){
				case 0:
					darkSide.add(new ClassPeasant(BaseHero.generateName(), 10, i));break;
				case 1:
					darkSide.add(new Snipper(BaseHero.generateName(), 10, i));break;
				case 2:
					darkSide.add(new Magician(BaseHero.generateName(), 10, i));break;
				default:
					darkSide.add(new Outlaw(BaseHero.generateName(), 10, i));break;
			}
		}
	}
	@Override
	public void dispose() {
		batch.dispose();
		fon.dispose();
	}
}