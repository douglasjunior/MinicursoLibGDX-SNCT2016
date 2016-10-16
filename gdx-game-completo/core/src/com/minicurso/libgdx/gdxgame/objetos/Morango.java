package com.minicurso.libgdx.gdxgame.objetos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.minicurso.libgdx.gdxgame.obstaculos.Obstaculo;
import com.minicurso.libgdx.gdxgame.util.Recursos;

/**
 * Created by Douglas on 16/10/2016.
 */

public class Morango extends Obstaculo {

    public Morango(Recursos recursos, World mundo, OrthographicCamera camera, float posicaoX) {
        super(recursos, mundo, camera, posicaoX);
    }

    /**
     * Cria a forma do corpo físico
     *
     * @return
     */
    @Override
    protected Shape initShape() {
        getCorpo().setFixedRotation(false);
        CircleShape shape = new CircleShape();
        shape.setRadius(getLarguraCorpo() / 2);
        return shape;
    }

    /**
     * Retorna a posição Y do corpo físico em metros
     *
     * @return
     */
    @Override
    protected float getPosicaoCorpoY() {
        return Chao.ALTURA_CORPO / 2 + getAlturaCorpo() / 2 + 4f;
    }

    /**
     * Retorna a largura da textura
     *
     * @return
     */
    @Override
    public float getLarguraTextura() {
        return 50;
    }

    /**
     * Retorna a altura da textura
     *
     * @return
     */
    @Override
    public float getAlturaTextura() {
        return 60;
    }

    /**
     * Retorna o objeto da textura
     *
     * @return
     */
    @Override
    protected Texture getTextura() {
        return recursos.txMorango;
    }

    /**
     * Retorna a pontuação do obstáculo
     *
     * @return
     */
    @Override
    public int getPontuacao() {
        return +20;
    }
}
