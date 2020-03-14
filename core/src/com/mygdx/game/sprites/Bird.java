package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    public static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;

    private Texture bird;
    private Rectangle birdich;
    private Sound sound;



    // конструктор класса Bird
    public Bird(int x, int y) {
        position = new Vector3(x, y,0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        birdich = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
        sound = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public void update(float dt) {
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt); // скалярная величина может отвечает за значение времени

        position.add(MOVEMENT * dt, velocity.y, 0);

        velocity.scl(1 / dt);

        birdich.setPosition(position.x, position.y);
    }

    public Rectangle getBirdich() {
        return birdich;
    }

    public void jump() {

        velocity.y = 250;
        sound.play()
    }
    public void dispose() {
        sound.play()
    }
}
