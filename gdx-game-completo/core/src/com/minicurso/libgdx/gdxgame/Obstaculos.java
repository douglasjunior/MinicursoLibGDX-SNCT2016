package com.minicurso.libgdx.gdxgame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Classe responsável por gerenciar os obstáculos, desde sua criação até o momento de ser destruído.
 * <p>
 * Created by Douglas on 16/10/2016.
 */
public class Obstaculos {

    private Recursos recursos;
    private World mundo;
    private OrthographicCamera camera;
    private Array<Obstaculo> obstaculos = new Array<Obstaculo>();

    public Obstaculos(Recursos recursos, World mundo, OrthographicCamera camera) {
        this.recursos = recursos;
        this.mundo = mundo;
        this.camera = camera;
    }

    /**
     * Desenha os obstáculos
     */
    public void desenhar(SpriteBatch batch) {
        for (Obstaculo obstaculo : obstaculos) {
            obstaculo.desenhar(batch);
        }
    }

    /**
     * Atualiza ou cria os obstáculos aleatoriamente
     *
     * @param delta
     */
    public void atualizar(float delta, Vector2 posicao) {
        // cria somente 1 obstáculos por vez
        if (obstaculos.size == 0) {
            // número aleatório para decidir qual obstáculo será criado
            int num = MathUtils.random(0, 2);
            Obstaculo obstaculo;
            switch (num) {
                case 0:
                    obstaculo = new Espinho(recursos, mundo, camera, posicao.x + 20);
                    break;
                case 1:
                    obstaculo = new Serra(recursos, mundo, camera, posicao.x + 20);
                    break;
                default:
                    obstaculo = new Barril(recursos, mundo, camera, posicao.x + 20);
                    break;
            }
            obstaculos.add(obstaculo);
        }

        // atualiza os obstáculos ou remove
        for (Iterator<Obstaculo> it = obstaculos.iterator(); it.hasNext(); ) {
            Obstaculo obs = it.next();
            if (obs.estaForaDaTela() || obs.isDestruir()) {
                it.remove();
                mundo.destroyBody(obs.getCorpo());
            } else {
                obs.atualizar(delta);
            }
        }
    }
}
