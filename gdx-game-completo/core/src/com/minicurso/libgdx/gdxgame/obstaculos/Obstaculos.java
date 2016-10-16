package com.minicurso.libgdx.gdxgame.obstaculos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.minicurso.libgdx.gdxgame.objetos.Abacaxi;
import com.minicurso.libgdx.gdxgame.objetos.Cenoura;
import com.minicurso.libgdx.gdxgame.objetos.Donut;
import com.minicurso.libgdx.gdxgame.objetos.Fritas;
import com.minicurso.libgdx.gdxgame.objetos.Lanche;
import com.minicurso.libgdx.gdxgame.objetos.Maca;
import com.minicurso.libgdx.gdxgame.objetos.Melancia;
import com.minicurso.libgdx.gdxgame.objetos.Morango;
import com.minicurso.libgdx.gdxgame.objetos.Pizza;
import com.minicurso.libgdx.gdxgame.util.Recursos;

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
     * Atualiza o estado dos obstáculos
     *
     * @param delta
     */
    public void atualizar(float delta, float posicaoInicialX) {
        // cria somente 1 obstáculos por vez
        if (obstaculos.size == 0) {
            criarObstaculo(posicaoInicialX);
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

    /**
     * Cria um obstáculo aleatório
     *
     * @param posicaoInicialX
     */
    private void criarObstaculo(float posicaoInicialX) {
        // número aleatório para decidir qual obstáculo será criado
        int num = MathUtils.random(0, 8);
        Obstaculo obstaculo = null;
        switch (num) {
            case 0:
                obstaculo = new Abacaxi(recursos, mundo, camera, posicaoInicialX);
                break;
            case 1:
                obstaculo = new Cenoura(recursos, mundo, camera, posicaoInicialX);
                break;
            case 2:
                obstaculo = new Donut(recursos, mundo, camera, posicaoInicialX);
                break;
            case 3:
                obstaculo = new Fritas(recursos, mundo, camera, posicaoInicialX);
                break;
            case 4:
                obstaculo = new Lanche(recursos, mundo, camera, posicaoInicialX);
                break;
            case 5:
                obstaculo = new Maca(recursos, mundo, camera, posicaoInicialX);
                break;
            case 6:
                obstaculo = new Melancia(recursos, mundo, camera, posicaoInicialX);
                break;
            case 7:
                obstaculo = new Morango(recursos, mundo, camera, posicaoInicialX);
                break;
            case 8:
                obstaculo = new Pizza(recursos, mundo, camera, posicaoInicialX);
                break;
        }
        obstaculos.add(obstaculo);
    }
}
