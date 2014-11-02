package com.BeefGames.PlutoWasAPlanetOnce.View.Handlers;

import com.BeefGames.PlutoWasAPlanetOnce.Model.Ship;
import com.BeefGames.PlutoWasAPlanetOnce.Upgrades.Nuke;
import com.BeefGames.PlutoWasAPlanetOnce.View.World;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

public class InputHandler implements InputProcessor{

	private World world;
	private Ship ship;

	private Array<Nuke> nukeArray;
	private BulletHandler bulletHandler;
	//private ParticleHandler particleHandler;

	
	public InputHandler(World world){
		this.world = world;
		ship = world.getShip();
		nukeArray = new Array<Nuke>();
		bulletHandler = new BulletHandler(world);
		//particleHandler = world.getParticleHandler();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
		case Keys.W:
			ship.getForce().y = ship.getForceMult();
			break;
		case Keys.S:
			ship.getForce().y = -ship.getForceMult();
			break;
		case Keys.A:
			ship.getForce().x = -ship.getForceMult();
			break;
		case Keys.D:
			ship.getForce().x = ship.getForceMult();
			break;
		case Keys.N:
			/*
			if(nukeArray.first() != null)
			{
				Nuke n = nukeArray.first();
				//n.detonate();
				System.out.println("NUKE");
				particleHandler = world.getParticleHandler();
				//particleHandler.addNuke();
				nukeArray.removeIndex(0);
			}*/
			break;
		case Keys.SPACE:
			bulletHandler.Fire(ship.getRotation());
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		//Handle ship movement
		ship = world.getShip();
		switch(keycode){
		case Keys.W:
			if(ship.getForce().y == ship.getForceMult())
				ship.getForce().y = 0;
			break;
		case Keys.S:
			if(ship.getForce().y == -ship.getForceMult())
				ship.getForce().y = 0;
			break;
		case Keys.A:
			if(ship.getForce().x == -ship.getForceMult())
				ship.getForce().x = 0;
			break;
		case Keys.D:
			if(ship.getForce().x == ship.getForceMult())
				ship.getForce().x = 0;
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// pointer - what finger
		
		//This fire method has been rewritten - need a different one for desktop shooting
		//bulletHandler.Fire(screenX, screenY);
		
		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//pointer - what finger
		
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return true;
	}
	public Array<Nuke> getNukes(){
		
		return nukeArray;
	}
	public void setNuke(Nuke n)
	{
		if(nukeArray.size <= 3)
		{
			nukeArray.add(n);
		}
	}
	public BulletHandler getBulletHandler()
	{
		return bulletHandler;
	}

}
