package com.minicurso.libgdx.gdxgame.obstaculos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.minicurso.libgdx.gdxgame.objetos.Chao;
import com.minicurso.libgdx.gdxgame.obstaculos.Obstaculo;
import com.minicurso.libgdx.gdxgame.util.Recursos;

import static com.minicurso.libgdx.gdxgame.util.Util.PIXEL_METRO;

/**
 * Created by Douglas on 16/10/2016.
 */

public class Cenoura extends Obstaculo {

    public Cenoura(Recursos recursos, World mundo, OrthographicCamera camera, float posicaoX) {
        super(recursos, mundo, camera, posicaoX);
    }

    /**
     * Retorna a posição Y do corpo físico em metros
     *
     * @return
     */
    @Override
    protected float getPosicaoCorpoY() {
        return Chao.ALTURA_CORPO / 2 + getAlturaCorpo() / 2;
    }

    /**
     * Retorna a largura da textura
     *
     * @return
     */
    @Override
    public float getLarguraTextura() {
        return 60;
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
     * Retorna a altura do corpo físico em metros
     *
     * @return
     */
    @Override
    protected float getAlturaCorpo() {
        return 40 / PIXEL_METRO;
    }

    /**
     * Retorna o objeto da textura
     *
     * @return
     */
    @Override
    protected Texture getTextura() {
        return recursos.txCenoura;
    }

    /**
     * Retorna a pontuação do obstáculo
     *
     * @return
     */
    @Override
    public int getPontuacao() {
        return +10;
    }
}
