package com.minicurso.libgdx.gdxgame.objetos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.minicurso.libgdx.gdxgame.obstaculos.Obstaculo;
import com.minicurso.libgdx.gdxgame.util.Recursos;

/**
 * Classe que representa a Donut
 * Created by Douglas on 14/05/2016.
 */
public class Donut extends Obstaculo {

    public Donut(Recursos recursos, World mundo, OrthographicCamera camera, float posicaoX) {
        super(recursos, mundo, camera, posicaoX);
    }

    /**
     * Cria a forma do corpo físico do Donut
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
     * Atualiza os atributos necessários do obstáculo
     *
     * @param delta
     */
    @Override
    protected void atualizar(float delta) {
        // incrementa o ângulo para fazer o efeito de rotação
        float angulo = getCorpo().getAngle() - delta * 5;
        getCorpo().setTransform(getCorpo().getPosition(), angulo);

        // chama o método atualizar genérico da classe Obstaculo
        super.atualizar(delta);
    }

    /**
     * Retorna a posição Y do corpo físico em metros
     *
     * @return
     */
    @Override
    protected float getPosicaoCorpoY() {
        return Chao.ALTURA_CORPO / 2 + getAlturaCorpo() / 2 + 2.6f;
    }

    /**
     * Retorna a largura da textura
     *
     * @return
     */
    @Override
    public float getLarguraTextura() {
        return 80;
    }

    /**
     * Retorna a altura da textura
     *
     * @return
     */
    @Override
    public float getAlturaTextura() {
        return 80;
    }

    /**
     * Retorna o objeto da textura
     *
     * @return
     */
    @Override
    protected Texture getTextura() {
        return recursos.txDonut;
    }

    /**
     * Retorna a pontuação do obstáculo
     *
     * @return
     */
    @Override
    public int getPontuacao() {
        return 0;
    }
}
